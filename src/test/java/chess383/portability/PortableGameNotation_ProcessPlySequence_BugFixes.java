/*
 *  PortableGameNotation_ProcessPlySequence_BugFixes.java
 *
 *  chess383 is a collection of chess related utilities.
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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinateFactory;
import chess383.position.Position;


/**
 * <p>
 * The class PortableGameNotation_ProcessPlySequence_BugFixes implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method String processPlySequence( ) for class PortableGameNotation is tested")
public class PortableGameNotation_ProcessPlySequence_BugFixes {
	
	@ParameterizedTest( name = "given a position \"{1}\" and a sequence of algebraic notations then the complete notation \"{0}\" should be returned." )
    @MethodSource("languageAndNotationAndpositionAndListOfMovesProvider")
    public void testWithArgMethodSource_ReturnCompleteNotation( Locale language, String notation, String fen, List<String> moves ) {
        
        ICoordinateFactory.STANDARD.get();
        String log = PortableGameNotation.create( Position.create( fen ) ).processPlySequence( language, moves );
        
        assertThat( notation )
                .as( String.format( "Given a position and a sequence of moves the the notation %s should be returned", notation ) )
                .isEqualTo( log );
    }
    
    
    public static Stream<Arguments> languageAndNotationAndpositionAndListOfMovesProvider() {
        return Stream.of(
            
            Arguments.of( Locale.GERMAN, " e2-e4  c7-c6  d2-d4  d7-d5  e4xd5  c6xd5 Lf1-d3 Sb8-c6  c2-c3  g7-g6 Sg1-e2 Sg8-h6  h2-h4 Lc8-f5  h4-h5 Lf5xd3 Dd1xd3 Dd8-d7 "+
                                         "Lc1-f4 Lf8-g7 Sb1-d2 Sh6-f5 O-O-O Sf5-d6  h5xg6  h7xg6 Th1xh8 Lg7xh8 Td1-h1 O-O-O Th1-h7  f7-f5 Dd3-g3 Dd7-e6 "+
            		                     "Lf4-e3 De6-g8 Th7-h6  e7-e5 Th6xg6 Dg8-f7  d4xe5 Sc6xe5 Tg6-h6 Sd6-e4 Dg3-h4 Lh8-g7 Th6-h5 Df7-d7 Dh4-h3 Td8-f8 Le3-d4 Dd7-b5 " +
                                         "Ld4xe5 Db5xe2 Le5-f4 Se4xf2 Dh3-f3 Sf2-d3 Kc1-b1 De2xf3 Sd2xf3 Sd3xf4",
            		      "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", 
            		      Arrays.asList( "e4", "c6", "d4", "d5", "exd5", "cxd5", "Bd3", "Nc6", "c3", "g6", "Ne2", "Nh6", "h4", "Bf5", "h5", "Bxd3", "Qxd3", "Qd7",
            		    		         "Bf4", "Bg7", "Nd2", "Nf5", "O-O-O", "Nd6", "hxg6", "hxg6", "Rxh8+", "Bxh8", "Rh1", "O-O-O", "Rh7", "f5", "Qg3", "Qe6",
            		    		         "Be3", "Qg8", "Rh6", "e5", "Rxg6", "Qf7", "dxe5", "Nxe5", "Rh6", "Ne4", "Qh4", "Bg7", "Rh5", "Qd7", "Qh3", "Rf8", "Bd4", "Qb5",
            		    		         "Bxe5", "Qxe2", "Bf4", "Nxf2", "Qf3", "Nd3+", "Kb1", "Qxf3", "Nxf3", "Nxf4" ) )
            
        ); }

}
