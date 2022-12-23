/*
 *  Lichess_Validation.java
 * 
 *  Copyright (C) 2022 Jörg Dippel
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
package chess383.runner;

import chess383.ICoordinateFactory;
import chess383.notation.Next;
import chess383.portability.PortableGameNotation;
import chess383.portability.PortableGameNotation_Filter;
import chess383.portability.PortableGameNotation_IO;
import chess383.portability.PortableGameNotation_POJO;
import chess383.position.Position;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


public class Lichess_Validation {

    private static boolean requiredValue ( String filterInput, int value ) {

        try {
            return filterInput != null && Integer.parseInt( filterInput ) >= value;
        }
        catch( NumberFormatException nfe ) {
            return false;
        }
    }

    private static boolean requiredSubstring ( String filterInput, String substring ) {

        return filterInput != null && filterInput.contains( substring );
    }

    public static void main(String[] args) {
        
        // final String ENCYCLOPEDIA = "lichess_first_10GB.pgn";
        final String ENCYCLOPEDIA = "lichess_2022-10.pgn";
        
        PortableGameNotation_IO input = PortableGameNotation_IO.create( "pgn/" +  ENCYCLOPEDIA);
        PortableGameNotation_POJO game;
        
        while( true ) {

            game = input.readGame();
            if( game.toString().trim().length() == 0 ) break;

            if( requiredSubstring( game.get( "Event" ).get( 0 ), "Classical ") &&
                requiredValue( game.get( "WhiteElo" ).get( 0 ), 2000 ) &&
                    requiredValue( game.get( "BlackElo" ).get( 0 ), 2000 )) {

                // System.out.println( game.toString() );
                // System.out.println( game.getNotation() );
                System.out.println( String.format( "%s:  %s (%s) - %s (%s)", game.get( "Opening" ), game.get( "White" ), game.get( "WhiteElo" ), game.get( "Black" ), game.get( "BlackElo" ) ) );
                System.out.print( PortableGameNotation_Filter.filter( game.getNotation() ) );
                System.out.println( );

                ICoordinateFactory.STANDARD.get();
                List<String> moves = Arrays.asList( PortableGameNotation_Filter.filter( game.getNotation() ).split( "\\s+" ) );
                try {
                    PortableGameNotation position = PortableGameNotation.create( Position.create() );
                    String log = position.processPlySequence( Locale.ENGLISH, moves );
                    System.out.println( log );
                }
                catch( Exception e ) {
                    Position position = Position.create();
                    Iterator<String> iterator = moves.iterator();
                    String move;
                    Position nextPosition;
                    while( iterator.hasNext() ) {

                        move = iterator.next();
                        try {
                            nextPosition = Next.create(position).next(move);
                            System.out.println( String.format( "%s   <%s>   %s", position, move, nextPosition ) );
                            position = nextPosition;
                        }
                        catch( Exception ne ) {
                            System.out.println( String.format( "Moves %s", moves ) );
                            System.out.println( String.format( "Critical move for %s   <%s>", position, move ) );
                            if(! moves.isEmpty() ) {
                                if( moves.get(0).trim().length() != 0 ) {
                                    break;
                                }
                            }
                        }
                    }
                }
                System.out.println( );
            }
        }

        System.out.println( String.format( "%s is read", ENCYCLOPEDIA ) );
    }
}
