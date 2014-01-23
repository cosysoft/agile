/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.exception;

/**
 *
 * @author Bluesky
 */
public class AgileException extends RuntimeException {

    public AgileException() {
    }

    public AgileException(String message) {
        super(message);
    }

    public AgileException(String message, Throwable cause) {
        super(message, cause);
    }

}
