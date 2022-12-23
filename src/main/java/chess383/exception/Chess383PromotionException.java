/*
 *  Chess383PromotionException.java
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

package chess383.exception;

/**
 * This class defines a derived exception.
 *
 * @author    Jörg Dippel
 * @version   August 2020
 * 
 */
public class Chess383PromotionException extends Chess383Exception {

    private static final long serialVersionUID = -8963615059482461368L;
 
    
    public Chess383PromotionException( ) { }

    public Chess383PromotionException( String message ) { super( message ); }
    
    public static void throwPromotionException( String message ) throws Chess383Exception {
        throw new Chess383PromotionException( String.format( "promotion exception:", message ) );
    }
}
