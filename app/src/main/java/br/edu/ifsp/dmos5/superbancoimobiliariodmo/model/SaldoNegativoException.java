package br.edu.ifsp.dmos5.superbancoimobiliariodmo.model;

import br.edu.ifsp.dmos5.superbancoimobiliariodmo.R;

public class SaldoNegativoException extends Exception {

    public SaldoNegativoException(){
        super(String.valueOf(R.string.exception_debit_invalid));

    }

}
