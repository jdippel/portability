/*
 *  PortableGameNotation_IO_ReadGame.java
 *
 *  chess383 is a collection of chess related utilities.
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class PortableGameNotation_IO_ReadGame implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method String readGame( ) for class PortableGameNotation_IO is tested")
public class PortableGameNotation_IO_ReadGame {  
  
	final String expectedOutput = 
	        "[Event \"IBM Kasparov vs. Deep Blue Rematch\"]" +
			"[Site \"New York, NY USA\"]" +
			"[Date \"1997.05.11\"]" + 
			"[Round \"6\"]" + 
			"[White \"Deep Blue\"]" +
			"[Black \"Kasparov, Garry\"]" +
			"[Opening \"Caro-Kann: 4...Nd7\"]" +
			"[ECO \"B17\"]" +
			"[Result \"1-0\"]" +
			" " +
			"1.e4 c6 2.d4 d5 3.Nc3 dxe4 4.Nxe4 Nd7 5.Ng5 Ngf6 6.Bd3 e6 7.N1f3 h6 " +
			"8.Nxe6 Qe7 9.O-O fxe6 10.Bg6+ Kd8 {Kasparov schüttelt kurz den Kopf} " +
			"11.Bf4 b5 12.a4 Bb7 13.Re1 Nd5 14.Bg3 Kc8 15.axb5 cxb5 16.Qd3 Bc6 " +
			"17.Bf5 exf5 18.Rxe7 Bxe7 19.c4 1-0";
	
	private boolean isSimilarExceptToWhiteSpaces( String first, String second ) {
	
		int outerCursor = 0;
		int innerCursor = 0;
		while( outerCursor < first.length() ) {
			if( Character.isWhitespace( first.charAt( outerCursor ) ) ) {
				outerCursor++;
			}
			else while( innerCursor < second.length() ) {
				if( Character.isWhitespace( second.charAt( innerCursor ) ) ) {
					innerCursor++;
				}
				else {
					
					if( second.charAt( innerCursor ) != first.charAt( outerCursor ) ) {
						if( Character.isWhitespace( first.charAt( outerCursor ) ) ) {
							break;
						}
						else {
							return( false );
						}
					}
					innerCursor++;
					outerCursor++;
				}	
			}
		}
		while( innerCursor < second.length() ) {
			if( Character.isWhitespace( second.charAt( innerCursor ) ) ) {
				innerCursor++;
			}
			else break;
		}
		while( outerCursor < first.length() ) {
			if( Character.isWhitespace( first.charAt( outerCursor ) ) ) {
				outerCursor++;
			}
			else break;
		}
		
		return( innerCursor == second.length() && outerCursor == first.length() );
	}
	
    @Test
    @DisplayName("game will be separated due to portable game notation")
    public void readFile_GamesWillBeSeparatedDueToPortableGameNotation() {

    	PortableGameNotation_IO input = PortableGameNotation_IO.create( "pgn/test.pgn" );
    	PortableGameNotation_POJO game = input.readGame();
		
		assertThat( isSimilarExceptToWhiteSpaces( game.toString(), expectedOutput.replaceAll( "\"", "" )))
		          .as( "the string representation of the portable game notation should match" )
		          .isTrue();
    }
    
    @Test
    @DisplayName("two games will be separated due to portable game notation")
    public void readFile_GamesWillBeSeparatedDueToPortableGameNotationRTepeated() {
        
    	PortableGameNotation_IO input = PortableGameNotation_IO.create( "pgn/testtest.pgn" );
    	PortableGameNotation_POJO game = input.readGame();
    	game = input.readGame();
        
    	assertThat( isSimilarExceptToWhiteSpaces( game.toString(), expectedOutput.replaceAll( "\"", "" )))
                  .as( "the string representation of the portable game notation should match" )
                  .isTrue();
    }
}


