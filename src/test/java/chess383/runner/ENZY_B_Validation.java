/*
 *  ENZY_B_Validation.java
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

import chess383.portability.PortableGameNotation_Filter;
import chess383.portability.PortableGameNotation_IO;
import chess383.portability.PortableGameNotation_POJO;

public class ENZY_B_Validation {

    public static void main(String[] args) {
        
        final String ENCYCLOPEDIA = "IB20111B.pgn";
        
        PortableGameNotation_IO input = PortableGameNotation_IO.create( "pgn/" +  ENCYCLOPEDIA);
        PortableGameNotation_POJO game;
        
        while( true ) {

            game = input.readGame();
            if( game.toString().trim().length() == 0 ) break;
            
            System.out.println( game.toString() );
            System.out.println( game.getNotation() );
            System.out.println( PortableGameNotation_Filter.filter( game.getNotation() ) );
            System.out.println( );
        }

        System.out.println( String.format( "%s is read", ENCYCLOPEDIA ) );
    }
}
