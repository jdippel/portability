# README #

This README documents a library for portability.

### What is this repository for? ###

* a library for portablity of chess notations.
* Version 3.0.10

### How do I get set up? ###

* This library will be included as a dependency

### Who do I talk to? ###

* Repo owner or admin

# portability #

With version 3.0.0 a parent pom is introduced that is part of chessparent repository.
The parent pom.xml is placed relatively one directory above the repository pom.xml.

# MVP (minimum viable product) #

Putting a PGN file in a determined directory the listed games can be filtered.
chess383.runner.Lichess_Search is an example for that - not configurable, but enough to make the point.

To run the example I've started my IDE.
To work with the result I've started the program on command line and redirect the result. The first lines of
stdout are lines like that:

[Scandinavian Defense: Mieses-Kotroc Variation]:  [elektron71] ([2092]) - [Tank_Abbott] ([2062]) - [1-0]   
e4 d5 exd5 Qxd5 d3 c6 Nf3 Bf5 Nc3 Qa5 Be2 e6 O-O Bd6 Be3 Nf6 a3 h6 h3 O-O Nh4 Bh7 Bd2 Qc7 Nf3 Nbd7 Re1 Nd5 Bf1 Rfe8 Ne4 Bf8 c4 N5f6 Nxf6 Nxf6 Bc3 Nd7 d4 Rad8 Qa4 Nb6 Qa5 c5 b4 cxb4 axb4 a6 b5 Ra8 Ne5 axb5 Qxb5 Rxa1 Rxa1 Ra8 Rxa8 Nxa8 Qe8 f6 Bb4   
e2-e4  d7-d5  e4xd5 Qd8xd5  d2-d3  c7-c6 Ng1-f3 Bc8-f5 Nb1-c3 Qd5-a5 Bf1-e2  e7-e6 O-O Bf8-d6 Bc1-e3 Ng8-f6  a2-a3  h7-h6  h2-h3 O-O Nf3-h4 Bf5-h7 Be3-d2 Qa5-c7 Nh4-f3 Nb8-d7 Rf1-e1 Nf6-d5 Be2-f1 Rf8-e8 Nc3-e4 Bd6-f8  c2-c4 Nd5-f6 Ne4xf6 Nd7xf6 Bd2-c3 Nf6-d7  d3-d4 Ra8-d8 Qd1-a4 Nd7-b6 Qa4-a5  c6-c5  b2-b4  c5xb4  a3xb4  a7-a6  b4-b5 Rd8-a8 Nf3-e5  a6xb5 Qa5xb5 Ra8xa1 Re1xa1 Re8-a8 Ra1xa8 Nb6xa8 Qb5-e8  f7-f6 Bc3-b4

[Scandinavian Defense: Modern Variation]:  [Chairmansclub] ([2068]) - [yt_hebabeats] ([2087]) - [1-0]   
e4 d5 exd5 Nf6 Nc3 Nxd5 Bc4 e6 Nf3 Be7 O-O O-O Re1 Nd7 d4 N7f6 Qe2 Re8 Bb3 a6 Ne4 b5 Bd2 Bb7 Nxf6 Nxf6 Ba5 Bxf3 Qxf3 Qxd4 Bxc7 Qxb2 a4 Qd4 axb5 Qc5 b6 Bd8 b7   
e2-e4  d7-d5  e4xd5 Ng8-f6 Nb1-c3 Nf6xd5 Bf1-c4  e7-e6 Ng1-f3 Bf8-e7 O-O O-O Rf1-e1 Nb8-d7  d2-d4 Nd7-f6 Qd1-e2 Rf8-e8 Bc4-b3  a7-a6 Nc3-e4  b7-b5 Bc1-d2 Bc8-b7 Ne4xf6 Nd5xf6 Bd2-a5 Bb7xf3 Qe2xf3 Qd8xd4 Ba5xc7 Qd4xb2  a2-a4 Qb2-d4  a4xb5 Qd4-c5  b5-b6 Be7-d8  b6-b7

[Scandinavian Defense: Main Line, Mieses Variation]:  [Alesuper07] ([2016]) - [Alpha4231] ([2013]) - [0-1]   
e4 d5 exd5 Nf6 d4 Qxd5 Nc3 Qa5 Bd2 c6 Bc4 Qc7 Nf3 Bg4 O-O e6 Re1 Bd6 h3 Bh5 Bg5 Nbd7 Qd3 Bg6 Qd2 O-O Bxf6 Nxf6 Ne5 Bxe5 dxe5 Rad8 Bd3 Bxd3 cxd3 Nd5 Re4 Qa5 Ra4 Qb6 Rg4 Qc7 Qh6 Qxe5 Kf1 Qf6 Qxf6 Nxf6 g3 Nxg4 hxg4 Rxd3 Ke2 Rfd8 Ne4 f5 gxf5 exf5 Nc5 Rd2 Ke3 Rxb2 Ne6 Re8 Kd4 Rxe6 a4 Rxf2 Rc1 Re4 Kd3 Rxa4 Re1 Re4 Re3 Kf7 Rxe4 fxe4 Kxe4 Ke6 Ke3 Rf8 Ke4 Rf6 Kd4 a5 Kc4 b5 Kb3 a4 Ka3 Rf5 Kb4 Rd5 Ka3 c5 Kb2 b4 Kc2 a3 Kb1 c4 Ka2 b3 Ka1 a2 Kb2 c3 Ka1 c2 Kb2 a1Q Kxa1 c1Q   
e2-e4  d7-d5  e4xd5 Ng8-f6  d2-d4 Qd8xd5 Nb1-c3 Qd5-a5 Bc1-d2  c7-c6 Bf1-c4 Qa5-c7 Ng1-f3 Bc8-g4 O-O  e7-e6 Rf1-e1 Bf8-d6  h2-h3 Bg4-h5 Bd2-g5 Nb8-d7 Qd1-d3 Bh5-g6 Qd3-d2 O-O Bg5xf6 Nd7xf6 Nf3-e5 Bd6xe5  d4xe5 Ra8-d8 Bc4-d3 Bg6xd3  c2xd3 Nf6-d5 Re1-e4 Qc7-a5 Re4-a4 Qa5-b6 Ra4-g4 Qb6-c7 Qd2-h6 Qc7xe5 Kg1-f1 Qe5-f6 Qh6xf6 Nd5xf6  g2-g3 Nf6xg4  h3xg4 Rd8xd3 Kf1-e2 Rf8-d8 Nc3-e4  f7-f5  g4xf5  e6xf5 Ne4-c5 Rd3-d2 Ke2-e3 Rd2xb2 Nc5-e6 Rd8-e8 Ke3-d4 Re8xe6  a2-a4 Rb2xf2 Ra1-c1 Re6-e4 Kd4-d3 Re4xa4 Rc1-e1 Ra4-e4 Re1-e3 Kg8-f7 Re3xe4  f5xe4 Kd3xe4 Kf7-e6 Ke4-e3 Rf2-f8 Ke3-e4 Rf8-f6 Ke4-d4  a7-a5 Kd4-c4  b7-b5 Kc4-b3  a5-a4 Kb3-a3 Rf6-f5 Ka3-b4 Rf5-d5 Kb4-a3  c6-c5 Ka3-b2  b5-b4 Kb2-c2  a4-a3 Kc2-b1  c5-c4 Kb1-a2  b4-b3 Ka2-a1  a3-a2 Ka1-b2  c4-c3 Kb2-a1  c3-c2 Ka1-b2  a2-a1Q Kb2xa1  c2-c1Q


