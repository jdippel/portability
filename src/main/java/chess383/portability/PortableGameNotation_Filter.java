/*
 *  PortableGameNotation_Filter.java
 * 
 *  Copyright (C) 2020 Jörg Dippel
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

/**
 * Provides a filter for algebraic notations.
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
public class PortableGameNotation_Filter {
	
    /**
     * Processes a given sequence of algebraic notations
     */
    public static String filter( String algebraicNotation ) {

    	StringBuffer buffer = new StringBuffer();
    	int cursor = 0;
    	char letter;
    	int length = algebraicNotation.length();

    	while( cursor < length ) {
    		
    		letter = algebraicNotation.charAt( cursor );
    		if( letter == '{' ) cursor += consumeComment( algebraicNotation.substring( cursor ) );
    		else if( Character.isWhitespace( letter ) ) {
    			cursor += consumeWhiteSpaces( algebraicNotation.substring( cursor ) );
    			if( buffer.length() > 0 ) buffer.append( ' ' );
    		}
    		else if( Character.isDigit( letter ) ) cursor += consumeNumbering( algebraicNotation.substring( cursor ) );
    		else if( Character.isLetterOrDigit( algebraicNotation.charAt( cursor ) ) ) {
    			int startIndex = cursor;
    			while( cursor < length && ( Character.isLetterOrDigit( algebraicNotation.charAt( cursor ) ) ||
						                    algebraicNotation.charAt( cursor ) == '-' ) ) {
					cursor++;
				}
				if( cursor == length ) buffer.append( algebraicNotation.substring( startIndex ) );
				else buffer.append( algebraicNotation.substring( startIndex, cursor ) );
    		}
			else {
				cursor++;
			}
     	}
    	return String.join( " ", buffer.toString().split( "\\s+" ) );
    }
    
    private static int consumeComment( String algebraicNotation ) {
    	
    	int cursor = 0;
    	int length = algebraicNotation.length();
    	while( cursor < length && algebraicNotation.charAt( cursor ) != '}' ) {
    		cursor++;
    	}
    	cursor++;
    	return cursor;
    }
    
    private static int consumeWhiteSpaces( String algebraicNotation ) {
    	
    	int cursor = 1;
    	int length = algebraicNotation.length();
    	while( cursor < length && Character.isWhitespace( algebraicNotation.charAt( cursor ) ) ) {
    		cursor++;
    	}
    	return cursor;
    }
    
    private static int consumeNumbering( String algebraicNotation ) {

    	int cursor = 0;
    	int length = algebraicNotation.length();
    	if( algebraicNotation.charAt(cursor) == '-' ) {
    		// result
    		while( cursor < length && ! Character.isWhitespace( algebraicNotation.charAt( cursor ) ) ) {
    			cursor++;
    		}
    	}
    	else if( algebraicNotation.charAt(cursor) == '/' ) {
    		// result
    		while( cursor < length && ! Character.isWhitespace( algebraicNotation.charAt( cursor ) ) ) {
    			cursor++;
    		}
    	}
    	else {
    		while( cursor < length && Character.isDigit( algebraicNotation.charAt( cursor ) )) {
        		cursor++;
        	}
        	while( cursor < length && '.' == algebraicNotation.charAt( cursor ) ) {
        		cursor++;
        	}
    	}
    	return cursor;
    }
}
