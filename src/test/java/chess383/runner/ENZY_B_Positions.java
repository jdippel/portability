/*
 *  ENZY_B_Positions.java
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
package chess383.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import chess383.ICoordinateFactory;
import chess383.portability.PortableGameNotation;
import chess383.portability.PortableGameNotation_Filter;
import chess383.portability.PortableGameNotation_IO;
import chess383.portability.PortableGameNotation_POJO;
import chess383.position.Position;

public class ENZY_B_Positions {

    public static void main(String[] args) {
        
        final String ENCYCLOPEDIA = "IB20111C.pgn";
        ICoordinateFactory.STANDARD.get();
        PortableGameNotation_IO input = PortableGameNotation_IO.create( "pgn/" +  ENCYCLOPEDIA);
        PortableGameNotation_POJO game;
            
        int counter = 1;
        while( true ) {

            game = input.readGame();
            if( game.toString().trim().length() == 0 ) break;
                
//            if( counter % 1000 == 0 ) 
            	System.out.println( "#" + counter );
            System.out.println( game.toString() );
            System.out.println( game.getNotation() );
            System.out.println( PortableGameNotation_Filter.filter( game.getNotation() ) );
            
            String log = PortableGameNotation.create( Position.create() ).processPlySequence( Locale.GERMAN, getMoves( PortableGameNotation_Filter.filter( game.getNotation() ) ) );
            System.out.println( log );
            System.out.println( );
            counter++;
        }
        System.out.println( String.format( "%s is read", ENCYCLOPEDIA ));
    }
    
    private static List<String> getMoves( String moves ) {
        
        List<String> list = new ArrayList<String>();
        String[] movesAsArray = moves.split( "\\s+" );
        for( String move : movesAsArray ) {
            list.add( move );
        }
        return list;
    }
}
