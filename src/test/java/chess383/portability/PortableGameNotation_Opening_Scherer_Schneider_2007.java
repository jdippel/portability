/*
 *  PortableGameNotation_Opening_Scherer_Schneider_2007.java
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
import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.notation.Ply;
import chess383.position.Position;
import chess383.transition.Transition;

/**
 * <p>
 * The class PortableGameNotation_Opening_Scherer_Schneider_2007 implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public method Position change( ) for class PortableGameNotation is tested for an opening to get a test case")
public class PortableGameNotation_Opening_Scherer_Schneider_2007 {  
    
	// #1603
    // [Event ""] [Site ""] [Date "2007.??.??"] [Round ""] [White "Scherer, Helmut"] [Black "Schneider, Bernd2"] [Result "0-1"] [WhiteElo "2314"] [BlackElo "2288"] [ECO "B13"] 1.e4 c6 2.d4 d5 3.exd5 cxd5 4.Bd3 Nc6 5.c3 g6 6.Ne2 Nh6 7.h4 Bf5 8.h5 Bxd3 9.Qxd3 Qd7 10.Bf4 Bg7 11.Nd2 Nf5 12.O-O-O Nd6 13.hxg6 hxg6 14.Rxh8+ Bxh8  15.Rh1 O-O-O 16.Rh7 f5 17.Qg3 Qe6 18.Be3 Qg8 19.Rh6 e5 20.Rxg6 Qf7 21.dxe5 Nxe5 22.Rh6 Ne4 23.Qh4 Bg7 24.Rh5 Qd7 25.Qh3 Rf8 26.Bd4 Qb5 27.Bxe5 Qxe2  28.Bf4 Nxf2 29.Qf3 Nd3+ 30.Kb1 Qxf3 31.Nxf3 Nxf4 0-1 
    // 1.e4 c6 2.d4 d5 3.exd5 cxd5 4.Bd3 Nc6 5.c3 g6 6.Ne2 Nh6 7.h4 Bf5 8.h5 Bxd3 9.Qxd3 Qd7 10.Bf4 Bg7 11.Nd2 Nf5 12.O-O-O Nd6 13.hxg6 hxg6 14.Rxh8+ Bxh8  15.Rh1 O-O-O 16.Rh7 f5 17.Qg3 Qe6 18.Be3 Qg8 19.Rh6 e5 20.Rxg6 Qf7 21.dxe5 Nxe5 22.Rh6 Ne4 23.Qh4 Bg7 24.Rh5 Qd7 25.Qh3 Rf8 26.Bd4 Qb5 27.Bxe5 Qxe2  28.Bf4 Nxf2 29.Qf3 Nd3+ 30.Kb1 Qxf3 31.Nxf3 Nxf4 0-1 
    // e4 c6 d4 d5 exd5 cxd5 Bd3 Nc6 c3 g6 Ne2 Nh6 h4 Bf5 h5 Bxd3 Qxd3 Qd7 Bf4 Bg7 Nd2 Nf5 O-O-O Nd6 hxg6 hxg6 Rxh8+ Bxh8 Rh1 O-O-O Rh7 f5 Qg3 Qe6 Be3 Qg8 Rh6 e5 Rxg6 Qf7 dxe5 Nxe5 Rh6 Ne4 Qh4 Bg7 Rh5 Qd7 Qh3 Rf8 Bd4 Qb5 Bxe5 Qxe2 Bf4 Nxf2 Qf3 Nd3+ Kb1 Qxf3 Nxf3 Nxf4
    // Exception in thread "main" chess383.statemachine.exception.PieceTypeToLocationAssertionViolationException: piece type on location h8 does not match the expected type
	
    @Test
    @DisplayName("change(): After capturing a rook the castling flags may be changed.")
    public void change() {
        
        // 1.e4 c6 2.d4 d5 3.exd5 cxd5 4.Bd3 Nc6 5.c3 g6 6.Ne2 Nh6 7.h4 Bf5 8.h5 Bxd3 9.Qxd3 Qd7 10.Bf4 Bg7
        // 11.Nd2 Nf5 12.O-O-O Nd6 13.hxg6 hxg6 

        Position  position =  Position.create("r3k2r/pp1qppb1/2nn2p1/3p4/3P1B2/2PQ4/PP1NNPP1/2KR3R w kq - 0 27" );
        
        assertThat( "r3k2r/pp1qppb1/2nn2p1/3p4/3P1B2/2PQ4/PP1NNPP1/2KR3R w kq - 0 27" )
                  .as( "the string representation of the new position should match" )
                  .isEqualTo( position.toString() );
        
        // 14. Rh1xh8
        position =  Transition.create( position ).change( "h1", "h8" );
        
        assertThat( "r3k2R/pp1qppb1/2nn2p1/3p4/3P1B2/2PQ4/PP1NNPP1/2KR4 b q - 0 28" )
                  .as( "the string representation of the new position should match - the castling flags must match!" )
                  .isEqualTo( position.toString() );
    }
    
    @Test
    @DisplayName("processPlySequence(): After capturing a rook the castling flags may be changed.")
    public void processPlySequence() {
        
        // 1.e4 c6 2.d4 d5 3.exd5 cxd5 4.Bd3 Nc6 5.c3 g6 6.Ne2 Nh6 7.h4 Bf5 8.h5 Bxd3 9.Qxd3 Qd7 10.Bf4 Bg7
        // 11.Nd2 Nf5 12.O-O-O Nd6 13.hxg6 hxg6 

    	Position position = Position.create( "r3k2r/pp1qppb1/2nn2p1/3p4/3P1B2/2PQ4/PP1NNPP1/2KR3R w kq - 0 27" );
    	String ply = "Rxh8";
    	
    	PortableGameNotation game = PortableGameNotation.create( position );  	
    	String log = game.processPlySequence( Locale.GERMAN, Arrays.asList( ply ) );
        
        assertThat( "Th1xh8" )
                  .as( "the string representation of the move description translated should match" )
                  .isEqualTo( log );
    }
    
    @Test
    @DisplayName("processPosition(): After capturing a rook the castling flags may be changed.")
    public void processPosition() {
        
        // 1.e4 c6 2.d4 d5 3.exd5 cxd5 4.Bd3 Nc6 5.c3 g6 6.Ne2 Nh6 7.h4 Bf5 8.h5 Bxd3 9.Qxd3 Qd7 10.Bf4 Bg7
        // 11.Nd2 Nf5 12.O-O-O Nd6 13.hxg6 hxg6 

    	Position position = Position.create( "r3k2r/pp1qppb1/2nn2p1/3p4/3P1B2/2PQ4/PP1NNPP1/2KR3R w kq - 0 27" );
    	String ply = "Rxh8";
    	
    	PortableGameNotation game = PortableGameNotation.create( position );
		Ply move = game.processPly( ply );
		
		position = game.processPosition( move );
		
		assertThat( "r3k2R/pp1qppb1/2nn2p1/3p4/3P1B2/2PQ4/PP1NNPP1/2KR4 b q - 0 28" )
                  .as( "the string representation of the new position should match - the castling flags must match!" )
                  .isEqualTo( position.toString() );
    }
}


