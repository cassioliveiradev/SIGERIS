package br.edu.uepb.sigeris.exceptions;

import java.io.Serializable;

public class NegocioException extends RuntimeException implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }
    
}
