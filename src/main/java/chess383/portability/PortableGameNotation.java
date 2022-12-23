/*
 *  PortableGameNotation.java
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

import java.util.List;
import java.util.Locale;

import chess383.exception.Chess383NotationException;
import chess383.notation.AlgebraicNotation;
import chess383.notation.Ply;
import chess383.position.Position;
import chess383.position.Promotion;
import chess383.transition.Transition;

public class PortableGameNotation {
	
   /** ---------  Attributes  -------------------------------- */
    
    private Position position;
    
    /** ---------  Constructors  ------------------------------ */
    
    private PortableGameNotation( Position position ) {
        setPosition( position );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private void setPosition( Position value )    { this.position = value; }
    private Position getPosition( )               { return this.position; }
    
    /** ---------  Factory  ----------------------------------- */
    
    static public PortableGameNotation create( Position position ) {
        
        return new PortableGameNotation( position );
    }

    /** ------------------------------------------------------- */
 
    /**
     * Processes a given ply given as a string
     *
     * A ply is given in Algebraic Notation as a string and it is converted to
     * Long Algebraic Notation which holds both source and target square.
     */
    public Ply processPly( String algebraicNotation ) {

    	return processPly( getPosition(), algebraicNotation );
    }
    
    /**
     * Processes a given ply given as a string
     *
     * A ply is given in Algebraic Notation as a string and it is converted to
     * Long Algebraic Notation which holds both source and target square.
     */
    private Ply processPly( Position position, String algebraicNotation ) {

    	return AlgebraicNotation.create( position ).expand( algebraicNotation );
    }
    
    /**
     * Processes a given position by a ply
     *
     * A ply is a move description in Long Algebraic Notation and holds both source and target locations.
     */
    public Position processPosition( Ply move ) {
    	
    	return processPosition( getPosition(), move );
    }
    
    /**
     * Processes a given position by a ply
     *
     * A ply is a move description in Long Algebraic Notation and holds both source and target locations.
     */
    private Position processPosition( Position position, Ply move ) {
    	
    	if( Ply.INVALID_MOVE.equals( move ) ) return null;
    	
    	Position processedPosition = Transition.create( position ).change( move.getOriginLocation(), move.getTargetLocation() );
    	if( move.getPromotion().length() > 0 ) {
    		processedPosition = Promotion.create( processedPosition ).promote( move.getTargetLocation(), move.getPromotion().charAt( 0 ) );
    	}
    	return processedPosition;
    }
    
    /**
     * Processes a sequence of plys which iterates from position to position.
     * 
     * The log of the executed plys is returned.
     */
    public String processPlySequence( Locale targetLanguage, List<String> moves ) {
    	
    	StringBuffer log = new StringBuffer();
    	Position position = getPosition();
    	
    	int cursor = 0;
    	while( cursor < moves.size() ) {
    		
    		String move = moves.get( cursor );
    		Ply ply = processPly( position, move );
    		ply = ply.translate( targetLanguage );
    		if( ply.isValid() ) {
    			position = processPosition( position, ply );
    			if( position != null ) {
    				log.append( (( cursor == 0 ) ? "" : " ") + ply.filterDescription() );
    			}
    			else {
    				throwException( "refused for transformation between positions", move );
    			}
    		}
    		else {
    			throwException( "invalid", move );
    		}
    		cursor++;
    	}
    	
    	return log.toString();
    }
    
    static private void throwException( String classification, String move ) {
    	
		Chess383NotationException.throwNotationException( String.format( "processPlySequence(): current move %s is classified as %s", move, classification ) );
    }
}
