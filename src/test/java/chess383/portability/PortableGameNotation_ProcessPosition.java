/*
 *  PortableGameNotation_ProcessPosition.java
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

import chess383.ICoordinateFactory;
import chess383.notation.AlgebraicNotation;
import chess383.notation.Ply;
import chess383.position.Position;

/**
 * <p>
 * The class PortableGameNotation_ProcessPosition implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2021
 *
 */
@DisplayName("the public method Position processPosition( ) for class PortableGameNotation is tested")
public class PortableGameNotation_ProcessPosition {
    
    @ParameterizedTest( name = "given a position \"{1}\" and an algebraic notations \"{0}\" then the newly position \"{2}\" should return if moved." )
    @MethodSource("positionAndPlyAndPositionProvider")
    public void testWithArgMethodSource_ReturnCreatedPosition( String move, String position, String createdPosition ) {
        
        ICoordinateFactory.STANDARD.get();
        Position definedPosition = Position.create( position );
        Ply ply = AlgebraicNotation.create( definedPosition ).expand( move );
        
        assertThat( createdPosition )
                .as( String.format( "Given a position and an algebraic move description the new position %s should be returned", createdPosition ) )
                .isEqualTo( PortableGameNotation.create(definedPosition).processPosition( ply ).toString() );
    }
    
    
    public static Stream<Arguments> positionAndPlyAndPositionProvider() {
        return Stream.of(
            
            // Slav Defense 
                
            Arguments.of( " d2-d4", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", "rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq d3 0 2" )
          , Arguments.of( " d7-d5", "rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq d3 0 2", "rnbqkbnr/ppp1pppp/8/3p4/3P4/8/PPP1PPPP/RNBQKBNR w KQkq d6 0 3" )
          , Arguments.of( " c2-c4", "rnbqkbnr/ppp1pppp/8/3p4/3P4/8/PPP1PPPP/RNBQKBNR w KQkq d6 0 3", "rnbqkbnr/ppp1pppp/8/3p4/2PP4/8/PP2PPPP/RNBQKBNR b KQkq c3 0 4" )
          , Arguments.of( " c7-c6", "rnbqkbnr/ppp1pppp/8/3p4/2PP4/8/PP2PPPP/RNBQKBNR b KQkq c3 0 4", "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/8/PP2PPPP/RNBQKBNR w KQkq - 0 5" )
          , Arguments.of( "Ng1-f3", "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/8/PP2PPPP/RNBQKBNR w KQkq - 1 5", "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R b KQkq - 2 6" )
          , Arguments.of( "Ng8-f6", "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R b KQkq - 2 6", "rnbqkb1r/pp2pppp/2p2n2/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R w KQkq - 3 7" )
          , Arguments.of( "Nb1-c3", "rnbqkb1r/pp2pppp/2p2n2/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R w KQkq - 3 7", "rnbqkb1r/pp2pppp/2p2n2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R b KQkq - 4 8" )
          , Arguments.of( " d5xc4", "rnbqkb1r/pp2pppp/2p2n2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R b KQkq - 4 8", "rnbqkb1r/pp2pppp/2p2n2/8/2pP4/2N2N2/PP2PPPP/R1BQKB1R w KQkq - 0 9" )
          , Arguments.of( " a2-a4", "rnbqkb1r/pp2pppp/2p2n2/8/2pP4/2N2N2/PP2PPPP/R1BQKB1R w KQkq a3 0 9", "rnbqkb1r/pp2pppp/2p2n2/8/P1pP4/2N2N2/1P2PPPP/R1BQKB1R b KQkq a3 0 10" )
          , Arguments.of( "Bc8-f5", "rnbqkb1r/pp2pppp/2p2n2/8/P1pP4/2N2N2/1P2PPPP/R1BQKB1R b KQkq a3 0 10", "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N2N2/1P2PPPP/R1BQKB1R w KQkq - 1 11" )
          , Arguments.of( " e2-e3", "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N2N2/1P2PPPP/R1BQKB1R w KQkq - 1 11", "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N1PN2/1P3PPP/R1BQKB1R b KQkq - 0 12" )
          , Arguments.of( " e7-e6", "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N1PN2/1P3PPP/R1BQKB1R b KQkq - 0 12", "rn1qkb1r/pp3ppp/2p1pn2/5b2/P1pP4/2N1PN2/1P3PPP/R1BQKB1R w KQkq - 0 13" )
          , Arguments.of( "Bf1xc4", "rn1qkb1r/pp3ppp/2p1pn2/5b2/P1pP4/2N1PN2/1P3PPP/R1BQKB1R w KQkq - 0 13", "rn1qkb1r/pp3ppp/2p1pn2/5b2/P1BP4/2N1PN2/1P3PPP/R1BQK2R b KQkq - 0 14" )
          , Arguments.of( "Bf8-b4", "rn1qkb1r/pp3ppp/2p1pn2/5b2/P1BP4/2N1PN2/1P3PPP/R1BQK2R b KQkq - 0 14", "rn1qk2r/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQK2R w KQkq - 1 15" )
          , Arguments.of( "O-O",    "rn1qk2r/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQK2R w KQkq - 1 15", "rn1qk2r/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQ1RK1 b kq - 2 16" )
          , Arguments.of( "O-O",    "rn1qk2r/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQ1RK1 b kq - 2 16", "rn1q1rk1/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQ1RK1 w - - 3 17" )
          , Arguments.of( "Qd1-b3", "rn1q1rk1/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P3PPP/R1BQ1RK1 w - - 3 17", "rn1q1rk1/pp3ppp/2p1pn2/5b2/PbBP4/1QN1PN2/1P3PPP/R1B2RK1 b - - 4 18" )
       
        ); }

}
