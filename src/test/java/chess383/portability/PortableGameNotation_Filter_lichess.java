/*
 *  PortableGameNotation_Filter_Filter.java
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * The class PortableGameNotation_Filter_Filter implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
@DisplayName("the public method String filter( ) for class PortableGameNotation_Filter is tested")
public class PortableGameNotation_Filter_lichess {

//	        [Event "Rated Classical game"]
//			[Site "https://lichess.org/1Ictj0p3"]
//			[Date "2022.10.01"]
//			[Round "-"]
//			[White "jpehez"]
//			[Black "NicolleVL"]
//			[Result "1-0"]
//			[UTCDate "2022.10.01"]
//			[UTCTime "00:00:28"]
//			[WhiteElo "1063"]
//			[BlackElo "1043"]
//			[WhiteRatingDiff "+59"]
//			[BlackRatingDiff "-13"]
//			[ECO "C41"]
//			[Opening "Philidor Defense: Nimzowitsch Variation"]
//			[TimeControl "1800+0"]
//			[Termination "Normal"]
//
//			1. e4 { [%eval 0.0] [%clk 0:30:00] } 1... e5 { [%eval 0.12] [%clk 0:30:00] } 2. Nf3 { [%eval 0.19] [%clk 0:29:57] } 2... d6?! { [%eval 0.82] [%clk 0:29:55] } 3. d4 { [%eval 0.57] [%clk 0:29:42] } 3... Nf6 { [%eval 0.93] [%clk 0:29:41] }
//	        4. Nc3 { [%eval 0.5] [%clk 0:29:25] } 4... Bg4? { [%eval 1.77] [%clk 0:29:09] } 5. Bg5? { [%eval 0.74] [%clk 0:29:00] } 5... exd4?! { [%eval 1.51] [%clk 0:28:52] } 6. Nd5?! { [%eval 0.59] [%clk 0:28:33] } 6... Nxe4?? { [%eval 8.76] [%clk 0:28:32] }
//	        7. Bxd8 { [%eval 8.83] [%clk 0:28:01] } 7... Kxd8 { [%eval 8.74] [%clk 0:28:32] } 8. Qxd4 { [%eval 8.73] [%clk 0:27:30] } 8... Bf5 { [%eval 11.37] [%clk 0:27:59] } 9. Ng5 { [%eval 8.37] [%clk 0:26:23] } 9... Nxg5 { [%eval 8.57] [%clk 0:27:28] }
//	        10. Bd3? { [%eval 5.96] [%clk 0:25:29] } 10... Nc6 { [%eval 6.25] [%clk 0:27:14] } 11. Qe3 { [%eval 6.36] [%clk 0:24:11] } 11... Be6 { [%eval 8.61] [%clk 0:25:59] } 12. c4? { [%eval 6.08] [%clk 0:23:04] } 12... h6 { [%eval 5.91] [%clk 0:25:42] }
//	        13. O-O { [%eval 5.89] [%clk 0:22:18] } 13... Na5? { [%eval 8.1] [%clk 0:24:42] } 14. b4 { [%eval 7.53] [%clk 0:20:13] } 14... Nxc4 { [%eval 8.49] [%clk 0:24:18] } 15. Bxc4 { [%eval 7.54] [%clk 0:20:03] } 15... c6 { [%eval 9.03] [%clk 0:23:41] }
//	        16. Rfe1 { [%eval 9.32] [%clk 0:17:47] } 16... cxd5 { [%eval 10.11] [%clk 0:23:26] } 17. Bxd5 { [%eval 10.06] [%clk 0:17:21] } 17... Rc8 { [%eval 10.59] [%clk 0:22:34] } 18. Bxb7 { [%eval 10.74] [%clk 0:16:18] } 18... Rc7 { [%eval 10.8] [%clk 0:18:11] }
//	        19. Qxa7 { [%eval 11.04] [%clk 0:14:49] } 19... Rxb7 { [%eval 19.47] [%clk 0:17:40] } 20. Qxb7 { [%eval #7] [%clk 0:14:43] } 20... d5 { [%eval #6] [%clk 0:17:21] } 21. Rac1 { [%eval #5] [%clk 0:14:15] } 21... g6 { [%eval #4] [%clk 0:16:25] }
//	        22. Qc7+ { [%eval #8] [%clk 0:13:40] } 22... Ke8 { [%eval #8] [%clk 0:16:10] } 23. b5?! { [%eval 13.06] [%clk 0:12:45] } 23... Bg7 { [%eval 18.62] [%clk 0:14:15] } 24. Qc6+ { [%eval 17.14] [%clk 0:12:15] } 24... Ke7 { [%eval 16.75] [%clk 0:13:59] }
//	        25. b6 { [%eval 11.81] [%clk 0:11:03] } 25... Rc8 { [%eval 25.88] [%clk 0:13:40] } 26. Qb7+ { [%eval 17.12] [%clk 0:10:41] } 26... Kd8?! { [%eval #2] [%clk 0:13:21] } 27. Rxc8+ { [%eval #1] [%clk 0:10:12] } 27... Bxc8 { [%eval #1] [%clk 0:13:19] }
//	        28. Qc7# { [%clk 0:09:58] } 1-0


    @Test
    @DisplayName("the ply squence will be filtered to Algebraic Notation only")
    public void filterSequence_FilteringToAlgebraicNotation() {
        

        String input =
                "1. e4 { [%eval 0.0] [%clk 0:30:00] } 1... e5 { [%eval 0.12] [%clk 0:30:00] } 2. Nf3 { [%eval 0.19] [%clk 0:29:57] } 2... d6?! { [%eval 0.82] [%clk 0:29:55] } 3. d4 { [%eval 0.57] [%clk 0:29:42] } 3... Nf6 { [%eval 0.93] [%clk 0:29:41] } " +
                "4. Nc3 { [%eval 0.5] [%clk 0:29:25] } 4... Bg4? { [%eval 1.77] [%clk 0:29:09] } 5. Bg5? { [%eval 0.74] [%clk 0:29:00] } 5... exd4?! { [%eval 1.51] [%clk 0:28:52] } 6. Nd5?! { [%eval 0.59] [%clk 0:28:33] } 6... Nxe4?? { [%eval 8.76] [%clk 0:28:32] } " +
                "7. Bxd8 { [%eval 8.83] [%clk 0:28:01] } 7... Kxd8 { [%eval 8.74] [%clk 0:28:32] } 8. Qxd4 { [%eval 8.73] [%clk 0:27:30] } 8... Bf5 { [%eval 11.37] [%clk 0:27:59] } 9. Ng5 { [%eval 8.37] [%clk 0:26:23] } 9... Nxg5 { [%eval 8.57] [%clk 0:27:28] } " +
                "10. Bd3? { [%eval 5.96] [%clk 0:25:29] } 10... Nc6 { [%eval 6.25] [%clk 0:27:14] } 11. Qe3 { [%eval 6.36] [%clk 0:24:11] } 11... Be6 { [%eval 8.61] [%clk 0:25:59] } 12. c4? { [%eval 6.08] [%clk 0:23:04] } 12... h6 { [%eval 5.91] [%clk 0:25:42] } " +
                "13. O-O { [%eval 5.89] [%clk 0:22:18] } 13... Na5? { [%eval 8.1] [%clk 0:24:42] } 14. b4 { [%eval 7.53] [%clk 0:20:13] } 14... Nxc4 { [%eval 8.49] [%clk 0:24:18] } 15. Bxc4 { [%eval 7.54] [%clk 0:20:03] } 15... c6 { [%eval 9.03] [%clk 0:23:41] } " +
                "16. Rfe1 { [%eval 9.32] [%clk 0:17:47] } 16... cxd5 { [%eval 10.11] [%clk 0:23:26] } 17. Bxd5 { [%eval 10.06] [%clk 0:17:21] } 17... Rc8 { [%eval 10.59] [%clk 0:22:34] } 18. Bxb7 { [%eval 10.74] [%clk 0:16:18] } 18... Rc7 { [%eval 10.8] [%clk 0:18:11] } " +
                "19. Qxa7 { [%eval 11.04] [%clk 0:14:49] } 19... Rxb7 { [%eval 19.47] [%clk 0:17:40] } 20. Qxb7 { [%eval #7] [%clk 0:14:43] } 20... d5 { [%eval #6] [%clk 0:17:21] } 21. Rac1 { [%eval #5] [%clk 0:14:15] } 21... g6 { [%eval #4] [%clk 0:16:25] } " +
                "22. Qc7+ { [%eval #8] [%clk 0:13:40] } 22... Ke8 { [%eval #8] [%clk 0:16:10] } 23. b5?! { [%eval 13.06] [%clk 0:12:45] } 23... Bg7 { [%eval 18.62] [%clk 0:14:15] } 24. Qc6+ { [%eval 17.14] [%clk 0:12:15] } 24... Ke7 { [%eval 16.75] [%clk 0:13:59] } " +
                "25. b6 { [%eval 11.81] [%clk 0:11:03] } 25... Rc8 { [%eval 25.88] [%clk 0:13:40] } 26. Qb7+ { [%eval 17.12] [%clk 0:10:41] } 26... Kd8?! { [%eval #2] [%clk 0:13:21] } 27. Rxc8+ { [%eval #1] [%clk 0:10:12] } 27... Bxc8 { [%eval #1] [%clk 0:13:19] }";
    	
    	String receivedFilteredSequence = PortableGameNotation_Filter.filter( input );
        
        assertThat( receivedFilteredSequence )
                  .as( "the string representation of the portable game notation should match" )
                  .isEqualTo( "e4 e5 Nf3 d6 d4 Nf6 Nc3 Bg4 Bg5 exd4 Nd5 Nxe4 Bxd8 Kxd8 Qxd4 Bf5 Ng5 Nxg5 Bd3 Nc6 Qe3 Be6 c4 h6 O-O Na5 b4 Nxc4 Bxc4 c6 Rfe1 cxd5 Bxd5 Rc8 Bxb7 Rc7 Qxa7 Rxb7 Qxb7 d5 Rac1 g6 Qc7 Ke8 b5 Bg7 Qc6 Ke7 b6 Rc8 Qb7 Kd8 Rxc8 Bxc8" );
    }

    @Test
    @DisplayName("game will be separated due to portable game notation")
    public void readFile_GamesWillBeSeparatedDueToPortableGameNotation() {

        String notation =
                "1. e4 { [%eval 0.0] [%clk 0:30:00] } 1... e5 { [%eval 0.12] [%clk 0:30:00] } 2. Nf3 { [%eval 0.19] [%clk 0:29:57] } 2... d6?! { [%eval 0.82] [%clk 0:29:55] } 3. d4 { [%eval 0.57] [%clk 0:29:42] } 3... Nf6 { [%eval 0.93] [%clk 0:29:41] } " +
                        "4. Nc3 { [%eval 0.5] [%clk 0:29:25] } 4... Bg4? { [%eval 1.77] [%clk 0:29:09] } 5. Bg5? { [%eval 0.74] [%clk 0:29:00] } 5... exd4?! { [%eval 1.51] [%clk 0:28:52] } 6. Nd5?! { [%eval 0.59] [%clk 0:28:33] } 6... Nxe4?? { [%eval 8.76] [%clk 0:28:32] } " +
                        "7. Bxd8 { [%eval 8.83] [%clk 0:28:01] } 7... Kxd8 { [%eval 8.74] [%clk 0:28:32] } 8. Qxd4 { [%eval 8.73] [%clk 0:27:30] } 8... Bf5 { [%eval 11.37] [%clk 0:27:59] } 9. Ng5 { [%eval 8.37] [%clk 0:26:23] } 9... Nxg5 { [%eval 8.57] [%clk 0:27:28] } " +
                        "10. Bd3? { [%eval 5.96] [%clk 0:25:29] } 10... Nc6 { [%eval 6.25] [%clk 0:27:14] } 11. Qe3 { [%eval 6.36] [%clk 0:24:11] } 11... Be6 { [%eval 8.61] [%clk 0:25:59] } 12. c4? { [%eval 6.08] [%clk 0:23:04] } 12... h6 { [%eval 5.91] [%clk 0:25:42] } " +
                        "13. O-O { [%eval 5.89] [%clk 0:22:18] } 13... Na5? { [%eval 8.1] [%clk 0:24:42] } 14. b4 { [%eval 7.53] [%clk 0:20:13] } 14... Nxc4 { [%eval 8.49] [%clk 0:24:18] } 15. Bxc4 { [%eval 7.54] [%clk 0:20:03] } 15... c6 { [%eval 9.03] [%clk 0:23:41] } " +
                        "16. Rfe1 { [%eval 9.32] [%clk 0:17:47] } 16... cxd5 { [%eval 10.11] [%clk 0:23:26] } 17. Bxd5 { [%eval 10.06] [%clk 0:17:21] } 17... Rc8 { [%eval 10.59] [%clk 0:22:34] } 18. Bxb7 { [%eval 10.74] [%clk 0:16:18] } 18... Rc7 { [%eval 10.8] [%clk 0:18:11] } " +
                        "19. Qxa7 { [%eval 11.04] [%clk 0:14:49] } 19... Rxb7 { [%eval 19.47] [%clk 0:17:40] } 20. Qxb7 { [%eval #7] [%clk 0:14:43] } 20... d5 { [%eval #6] [%clk 0:17:21] } 21. Rac1 { [%eval #5] [%clk 0:14:15] } 21... g6 { [%eval #4] [%clk 0:16:25] } " +
                        "22. Qc7+ { [%eval #8] [%clk 0:13:40] } 22... Ke8 { [%eval #8] [%clk 0:16:10] } 23. b5?! { [%eval 13.06] [%clk 0:12:45] } 23... Bg7 { [%eval 18.62] [%clk 0:14:15] } 24. Qc6+ { [%eval 17.14] [%clk 0:12:15] } 24... Ke7 { [%eval 16.75] [%clk 0:13:59] } " +
                        "25. b6 { [%eval 11.81] [%clk 0:11:03] } 25... Rc8 { [%eval 25.88] [%clk 0:13:40] } 26. Qb7+ { [%eval 17.12] [%clk 0:10:41] } 26... Kd8?! { [%eval #2] [%clk 0:13:21] } 27. Rxc8+ { [%eval #1] [%clk 0:10:12] } 27... Bxc8 { [%eval #1] [%clk 0:13:19] } " +
                        "28. Qc7# { [%clk 0:09:58] } 1-0 ";

        PortableGameNotation_POJO game = PortableGameNotation_IO.create( "pgn/lichess_classical.pgn" ).readGame();
        String receivedSequence = game.getNotation();

        assertThat( receivedSequence )
                .as( "the string representation of the portable game notation should match" )
                .isEqualTo( notation );
    }

    @Test
    @DisplayName("game will be separated due to portable game notation")
    public void readFileAndFilter_GamesWillBeSeparatedDueToPortableGameNotation() {

        String notation =
                "1. e4 { [%eval 0.0] [%clk 0:30:00] } 1... e5 { [%eval 0.12] [%clk 0:30:00] } 2. Nf3 { [%eval 0.19] [%clk 0:29:57] } 2... d6?! { [%eval 0.82] [%clk 0:29:55] } 3. d4 { [%eval 0.57] [%clk 0:29:42] } 3... Nf6 { [%eval 0.93] [%clk 0:29:41] } " +
                        "4. Nc3 { [%eval 0.5] [%clk 0:29:25] } 4... Bg4? { [%eval 1.77] [%clk 0:29:09] } 5. Bg5? { [%eval 0.74] [%clk 0:29:00] } 5... exd4?! { [%eval 1.51] [%clk 0:28:52] } 6. Nd5?! { [%eval 0.59] [%clk 0:28:33] } 6... Nxe4?? { [%eval 8.76] [%clk 0:28:32] } " +
                        "7. Bxd8 { [%eval 8.83] [%clk 0:28:01] } 7... Kxd8 { [%eval 8.74] [%clk 0:28:32] } 8. Qxd4 { [%eval 8.73] [%clk 0:27:30] } 8... Bf5 { [%eval 11.37] [%clk 0:27:59] } 9. Ng5 { [%eval 8.37] [%clk 0:26:23] } 9... Nxg5 { [%eval 8.57] [%clk 0:27:28] } " +
                        "10. Bd3? { [%eval 5.96] [%clk 0:25:29] } 10... Nc6 { [%eval 6.25] [%clk 0:27:14] } 11. Qe3 { [%eval 6.36] [%clk 0:24:11] } 11... Be6 { [%eval 8.61] [%clk 0:25:59] } 12. c4? { [%eval 6.08] [%clk 0:23:04] } 12... h6 { [%eval 5.91] [%clk 0:25:42] } " +
                        "13. O-O { [%eval 5.89] [%clk 0:22:18] } 13... Na5? { [%eval 8.1] [%clk 0:24:42] } 14. b4 { [%eval 7.53] [%clk 0:20:13] } 14... Nxc4 { [%eval 8.49] [%clk 0:24:18] } 15. Bxc4 { [%eval 7.54] [%clk 0:20:03] } 15... c6 { [%eval 9.03] [%clk 0:23:41] } " +
                        "16. Rfe1 { [%eval 9.32] [%clk 0:17:47] } 16... cxd5 { [%eval 10.11] [%clk 0:23:26] } 17. Bxd5 { [%eval 10.06] [%clk 0:17:21] } 17... Rc8 { [%eval 10.59] [%clk 0:22:34] } 18. Bxb7 { [%eval 10.74] [%clk 0:16:18] } 18... Rc7 { [%eval 10.8] [%clk 0:18:11] } " +
                        "19. Qxa7 { [%eval 11.04] [%clk 0:14:49] } 19... Rxb7 { [%eval 19.47] [%clk 0:17:40] } 20. Qxb7 { [%eval #7] [%clk 0:14:43] } 20... d5 { [%eval #6] [%clk 0:17:21] } 21. Rac1 { [%eval #5] [%clk 0:14:15] } 21... g6 { [%eval #4] [%clk 0:16:25] } " +
                        "22. Qc7+ { [%eval #8] [%clk 0:13:40] } 22... Ke8 { [%eval #8] [%clk 0:16:10] } 23. b5?! { [%eval 13.06] [%clk 0:12:45] } 23... Bg7 { [%eval 18.62] [%clk 0:14:15] } 24. Qc6+ { [%eval 17.14] [%clk 0:12:15] } 24... Ke7 { [%eval 16.75] [%clk 0:13:59] } " +
                        "25. b6 { [%eval 11.81] [%clk 0:11:03] } 25... Rc8 { [%eval 25.88] [%clk 0:13:40] } 26. Qb7+ { [%eval 17.12] [%clk 0:10:41] } 26... Kd8?! { [%eval #2] [%clk 0:13:21] } 27. Rxc8+ { [%eval #1] [%clk 0:10:12] } 27... Bxc8 { [%eval #1] [%clk 0:13:19] } " +
                        "28. Qc7# { [%clk 0:09:58] } 1-0 ";

        PortableGameNotation_POJO game = PortableGameNotation_IO.create( "pgn/lichess_classical.pgn" ).readGame();
        String receivedFilteredSequence = PortableGameNotation_Filter.filter( game.getNotation() );

        assertThat( receivedFilteredSequence )
                .as( "the string representation of the portable game notation should match" )
                .isEqualTo( "e4 e5 Nf3 d6 d4 Nf6 Nc3 Bg4 Bg5 exd4 Nd5 Nxe4 Bxd8 Kxd8 Qxd4 Bf5 Ng5 Nxg5 Bd3 Nc6 Qe3 Be6 c4 h6 O-O Na5 b4 Nxc4 Bxc4 c6 Rfe1 cxd5 Bxd5 Rc8 Bxb7 Rc7 Qxa7 Rxb7 Qxb7 d5 Rac1 g6 Qc7 Ke8 b5 Bg7 Qc6 Ke7 b6 Rc8 Qb7 Kd8 Rxc8 Bxc8 Qc7" );
    }
}


