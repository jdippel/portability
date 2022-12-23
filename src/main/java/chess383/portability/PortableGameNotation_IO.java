/*
 *  PortableGameNotation_IO.java
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
package chess383.portability;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import chess383.exception.Chess383IOException;

public class PortableGameNotation_IO {
    
   /** ---------  Attributes  -------------------------------- */
    
    private BufferedReader incoming;
    
    /** ---------  Constructors  ------------------------------ */
    
    private PortableGameNotation_IO( BufferedReader incoming ) {
        setIncoming( incoming );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private void setIncoming( BufferedReader value )    { this.incoming = value; }
    private BufferedReader getIncoming( )               { return this.incoming; }
    
    /** ---------  Factory  ----------------------------------- */
    
    static public PortableGameNotation_IO create( BufferedReader incoming ) {
        
        return new PortableGameNotation_IO( incoming );
    }
    
    static public PortableGameNotation_IO create( String incoming ) {
        
        try {
            BufferedReader reader = new BufferedReader( new FileReader( incoming ) );
            return create( reader );
        } catch( FileNotFoundException e ) {
            Chess383IOException.throwIOException( incoming );
            return null;
        }
    }

    /** ------------------------------------------------------- */
    
    public PortableGameNotation_POJO readGame() {
        
        String line;
        BufferedReader reader = getIncoming();
        
        PortableGameNotation_POJO pojo = PortableGameNotation_POJO.create();
        StringBuffer moveSequence = new StringBuffer();
        try {
            while( ( line = reader.readLine() ) != null ) {
                if( line.trim().length() > 0 ) {
                    if( pojo.startsWithBeginOfAttribute( line ) && pojo.containsEndOfAttribute( line ) ) {
                        pojo.consumeAttribute( line );
                    }
                    else break;
                }
                else break;
            }
            while( ( line = reader.readLine() ) != null ) {
                if( line.trim().length() > 0 ) {
                    moveSequence.append( line + " " );
                }
                else {
                    String notation = moveSequence.toString();
                    pojo.consumeSequence( notation );
                    break;
                };
            }   
        } catch ( IOException ioe ) {
            Chess383IOException.throwIOException( "exception on reading game" );
        }
        return pojo;
    }
}
