/*
 *  PortableGameNotation_ProcessPlySequence.java
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

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.position.Position;


/**
 * <p>
 * The class PortableGameNotation_ProcessPlySequence implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2021
 *
 */
@DisplayName("the public method String processPlySequence( ) for class PortableGameNotation is tested")
public class PortableGameNotation_ProcessPlySequence {
	
	@ParameterizedTest( name = "given a position \"{3}\" and a sequence of algebraic notations then the complete notation \"{2}\" should be returned." )
    @MethodSource("languageAndNotationAndpositionAndListOfMovesProvider")
    public void testWithArgMethodSource_ReturnCompleteNotation( Locale targetLanguage, String notation, String fen, List<String> moves ) {

        String log = PortableGameNotation.create( Position.create( fen ) ).processPlySequence( targetLanguage, moves );
        
        assertThat( notation )
                .as( String.format( "Given a position and a sequence of moves the the notation %s should be returned", notation ) )
                .isEqualTo( log );
    }
    
    
    public static Stream<Arguments> languageAndNotationAndpositionAndListOfMovesProvider() {
        return Stream.of(

            Arguments.of( Locale.ENGLISH, "Ng1-f3 Nb8-c6", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", Arrays.asList( "Nf3", "Nc6" ) ),
            Arguments.of( Locale.GERMAN,  "Sg1-f3 Sb8-c6", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", Arrays.asList( "Nf3", "Nc6" ) ),
            
            Arguments.of( Locale.GERMAN,  " d2-d4  d7-d5  c2-c4  c7-c6 Sg1-f3 Sg8-f6 Sb1-c3  d5xc4  a2-a4 Lc8-f5  e2-e3  e7-e6 Lf1xc4 Lf8-b4 O-O O-O Dd1-b3", 
            		      "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", 
            		      Arrays.asList( "d4", "d5", "c4", "c6", "Nf3", "Nf6", "Nc3", "dxc4", "a4", "Bf5", "e3", "e6", "Bxc4", "Bb4", "O-O", "O-O", "Qb3" ) )
            
        ); }

}
