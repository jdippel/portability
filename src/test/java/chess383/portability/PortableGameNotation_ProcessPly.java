/*
 *  PortableGameNotation_ProcessPly.java
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

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.notation.Ply;
import chess383.position.Position;

/**
 * <p>
 * The class PortableGameNotation_ProcessPly implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   September 2021
 *
 */
@DisplayName("the public method Ply processPly( ) for class PortableGameNotation is tested")
public class PortableGameNotation_ProcessPly {
    
    @ParameterizedTest( name = "given a position \"{1}\" and an algebraic notations \"{0}\" then the complete notation \"{2}\" should be returned." )
    @MethodSource("notationAndpositionAndPlyProvider")
    public void testWithArgMethodSource_ReturnCompleteNotation( String notation, String fen, String ply) {
        
        Position position = Position.create( fen );
        Ply receivedPly = PortableGameNotation.create( position ).processPly( notation ).setDescription();
        
        assertThat( ply )
                .as( String.format( "Given a position and an algebraic move description the the notation %s should be returned", ply ) )
                .isEqualTo( receivedPly.getDescription() );
    }
    
    
    public static Stream<Arguments> notationAndpositionAndPlyProvider() {
        return Stream.of(
            
            // Slav Defense 
                
            Arguments.of(   "d4", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", " d2-d4" )
          , Arguments.of(   "d5", "rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq d3 0 2", " d7-d5" )
          , Arguments.of(   "c4", "rnbqkbnr/ppp1pppp/8/3p4/3P4/8/PPP1PPPP/RNBQKBNR w KQkq d6 0 3", " c2-c4" )
          , Arguments.of(   "c6", "rnbqkbnr/ppp1pppp/8/3p4/2PP4/8/PP2PPPP/RNBQKBNR b KQkq c3 0 4", " c7-c6" )
          , Arguments.of(  "Nf3", "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/8/PP2PPPP/RNBQKBNR w KQkq - 0 5", "Sg1-f3" )
          , Arguments.of(  "Nf6", "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R b KQkq - 2 6", "Sg8-f6" )
          , Arguments.of(  "Nc3", "rnbqkb1r/pp2pppp/2p2n2/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R w KQkq - 3 7", "Sb1-c3" )
          , Arguments.of( "dxc4", "rnbqkb1r/pp2pppp/2p2n2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R b KQkq - 4 8", " d5xc4" )
          , Arguments.of(   "a4", "rnbqkb1r/pp2pppp/2p2n2/8/2pP4/2N2N2/PP2PPPP/R1BQKB1R w KQkq - 0 9", " a2-a4" )
          , Arguments.of(  "Bf5", "rnbqkb1r/pp2pppp/2p2n2/8/P1pP4/2N2N2/1P2PPPP/R1BQKB1R b KQkq a3 1 10", "Lc8-f5" )
          , Arguments.of(   "e3", "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N2N2/1P2PPPP/R1BQKB1R w KQkq - 1 11", " e2-e3" )
          , Arguments.of(   "e6", "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N1PN2/1P3PPP/R1BQKB1R b KQkq - 0 12", " e7-e6" )
          , Arguments.of( "Bxc4", "rn1qkb1r/pp3ppp/2p1pn2/5b2/P1pP4/2N1PN2/1P3PPP/R1BQKB1R w KQkq - 0 13", "Lf1xc4" )
          , Arguments.of(  "Bb4", "rn1qkb1r/pp3ppp/2p1pn2/5b2/P1BP4/2N1PN2/1P3PPP/R1BQK2R b KQkq - 0 14", "Lf8-b4" )
          , Arguments.of(  "O-O", "rn1qk2r/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQK2R w KQkq - 1 15", "Ke1-g1" )
          , Arguments.of(  "O-O", "rn1qk2r/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQ1RK1 b kq - 2 16", "Ke8-g8" )
          , Arguments.of(  "Qb3", "rn1q1rk1/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQ1RK1 w - - 3 17", "Dd1-b3" )
       
        ); }

}
