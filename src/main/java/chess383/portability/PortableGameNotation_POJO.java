/*
 *  PortableGameNotation_POJO.java
 * 
 *  Copyright (C) 2020, 2021 Jörg Dippel
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package chess383.portability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortableGameNotation_POJO {
	
	final char ATTRIBUTE_START_SYMBOL = '[';
	final char ATTRIBUTE_END_SYMBOL = ']';
	final String NOTATION = "notation";
	final List<String> BASIC_KEYS = Arrays.asList( "Event", "Site", "Date", "Round", "White", "Black", "Opening", "ECO", "Result", "WhiteElo", "BlackElo" );
	
    /** ---------  Attributes  -------------------------------- */
    
	Map<String, List<String>> dictionary;
    
    /** ---------  Constructors  ------------------------------ */
    
    private PortableGameNotation_POJO() {
    	setDictionary();
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private void setDictionary() {
    	
    	dictionary = new HashMap<String, List<String>>( BASIC_KEYS.size() );
    	
    	for( String key: BASIC_KEYS ) {
    		dictionary.put( key, new ArrayList<String>() );
    	}
    	dictionary.put( NOTATION, new ArrayList<String>() );
    }

    /** ---------  Factory  ----------------------------------- */
    
    static public PortableGameNotation_POJO create() {
        
        return new PortableGameNotation_POJO();
    }

    /** ------------------------------------------------------- */
 
    private void addToDictionary ( String key, String value ) {
    	
    	if( dictionary.get( key ) == null ) {
    		dictionary.put( key, new ArrayList<String>() );
    	}
    	dictionary.get( key ).add( value );
    }
    
    public boolean startsWithBeginOfAttribute( String attribute ) {
    	
    	int cursor = 0;
    	while( Character.isWhitespace( attribute.charAt( cursor ) ) ) cursor++;
    	return( ATTRIBUTE_START_SYMBOL == attribute.charAt( cursor ) );
    }
    
    public boolean containsEndOfAttribute( String attribute ) {
    	
    	int cursor = 0;
    	while( cursor < attribute.length() ) {
    		if( ATTRIBUTE_END_SYMBOL == attribute.charAt( cursor ) ) return true;
    		cursor++;
    	}
    	return false;
    }

	private String strip( String attribute ) {

		int length = attribute.length();
		if( length > 2 ) {
			if (attribute.charAt(0) == '"' && attribute.charAt(length - 1) == '"') return strip(attribute.substring(1, length - 1));
		}
		return attribute;
	}

    public String consumeAttribute( String attribute ) {
    	
    	int length = attribute.length();
    	if( startsWithBeginOfAttribute( attribute ) ) {
    		int cursor = attribute.indexOf( ATTRIBUTE_START_SYMBOL ) + 1;
    		while( cursor < length && Character.isWhitespace( attribute.charAt( cursor ) ) ) cursor++;
    		if( containsEndOfAttribute( attribute ) ) {
        		int startCursor = cursor;
        		while( cursor < length && Character.isLetterOrDigit( attribute.charAt( cursor ) ) ) cursor++;
        		String key = attribute.substring( startCursor, cursor );
        		
        		while( cursor < length && Character.isWhitespace( attribute.charAt( cursor ) ) ) cursor++;
        		startCursor = cursor;
        		cursor = attribute.indexOf( ATTRIBUTE_END_SYMBOL );
				String value = strip( attribute.substring( startCursor, cursor ));
        		addToDictionary( key, value );
        		
        		cursor++;
        		while( cursor < length && Character.isWhitespace( attribute.charAt( cursor ) ) ) cursor++;
        		if( cursor == length ) return "";
        		else return attribute.substring( cursor );
    	    }
    		else {
    			return attribute.substring( cursor );
    		}
    	}
    	return "";
    }

	private int findEndOfComment( String comment ) {

		int numberOfStartingComments = 1;
		int end = comment.indexOf( '}' );
		if( end == -1 ) return( 1 );    // not wellformed

		int start = comment.indexOf( '{' );
		while( numberOfStartingComments > 0 ) {
			if( start == -1 ) {
				numberOfStartingComments--;
			}
			else if ( start > end ) {
				numberOfStartingComments--;
			}
			else {
				end = comment.substring( end + 1 ).charAt( '}' );
				numberOfStartingComments++;
			}
		}
		return( end + 1 );
	}
    public String consumeSequence( String moveSquence ) {
    	
    	int length = moveSquence.length();
    	int cursor = 0;
    	while( cursor < length && Character.isWhitespace( moveSquence.charAt( cursor ) ) ) cursor++;
    	int startCursor = cursor;
    	while( cursor < length ) {
			char letter =  moveSquence.charAt( cursor );
			if( letter == '{' ) cursor += findEndOfComment( moveSquence.substring( cursor + 1 ) );
			if( letter == ATTRIBUTE_START_SYMBOL ) break;
			cursor++;
		}
    	
    	if( cursor == length ) {
    		dictionary.get( NOTATION ).add( moveSquence.substring( startCursor ) );
    		return "";
    	}
    	else {
    		dictionary.get( NOTATION ).add( moveSquence.substring( startCursor, cursor - 1 ) );
    		return moveSquence.substring( cursor );
    	}
    }    
    
    public List<String> getKeys() {
    	return BASIC_KEYS;
    }
    
    public List<String> get( String key ) {
    	return dictionary.get( key );
    }
    
    public String getNotation() {
    	return ( dictionary.get( NOTATION ).size() > 0 ) ? dictionary.get( NOTATION ).get( 0 ) : "";
    }
    
    public int produceIntegerValue( String key ) {
    	
    	List<String> values = get( key );
    	if( values == null || values.isEmpty() ) return 0;
    	
    	String value = values.get( 0 );
    	if( Character.isDigit( value.charAt( 0 ) ) ) return Integer.parseInt( value );
    	
    	int cursor = 0;
    	while( cursor < value.length() && ( ! Character.isDigit( value.charAt( cursor ) ) )) cursor ++;
    	int start = cursor;
    	while( cursor < value.length() && Character.isDigit( value.charAt( cursor ) ) ) cursor ++;
    	
    	try {
    		return( cursor == value.length() ) ? Integer.parseInt( value.substring( start ) ) : Integer.parseInt( value.substring( start, cursor ) );
    	}
    	catch( NumberFormatException nfe ) {
    		return 0;
    	}
    }
    
    public String produceStringValue( String key ) {
    	
    	List<String> values = get( key );
    	if( values == null || values.isEmpty() ) return "";
    	
    	String value = values.get( 0 );
    	if( '"' == value.charAt( 0 ) ) return value.substring( 1, value.length() - 1 );
    	return value;
    }
    
/** ---------  Inheritance from Object  ------------------- */
    
    @Override
    public String toString() {
    
    	StringBuffer buffer = new StringBuffer();
    	
    	for( String key : getKeys() ) {
    		buffer.append( getValueFromKey( key ) );
    	}
    	for( String key : dictionary.keySet() ) {
    		if( ! BASIC_KEYS.contains( key ) && NOTATION.compareTo( key ) != 0 ) {
    			buffer.append( getValueFromKey( key ) );
    		}
    	}
    	
    	buffer.append( String.format( "%s\n", getNotation() ) );
        return buffer.toString();
    }
    
    private String getValueFromKey( String key ) {
    	
    	StringBuffer buffer = new StringBuffer();
    	
    	List<String> values = dictionary.get( key );
    	int length = values.size();
		for( int cursor = 0; cursor < length; cursor++ )
		{
			String value = values.get( cursor );
			if( value.length() > 0 ) {
				buffer.append( String.format( "%c%s %s%c\n", ATTRIBUTE_START_SYMBOL, key, value, ATTRIBUTE_END_SYMBOL ) );
			}
		}
		
		return buffer.toString();
    }
}
