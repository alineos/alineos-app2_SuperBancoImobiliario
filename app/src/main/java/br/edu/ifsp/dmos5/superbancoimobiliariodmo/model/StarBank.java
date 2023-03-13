package br.edu.ifsp.dmos5.superbancoimobiliariodmo.model;


public class StarBank {

     private static CreditCard[] listCard  = new CreditCard[6];


    private static StarBank instance = null;


    private StarBank() {

    } //construtor

    public static StarBank getInstance() {
        if (instance == null) {
            instance = new StarBank();

            for (int i=0;i<=5;i++){
                listCard[i]= new CreditCard();
            }
        }
        return instance;
    }

    public void setInstance(StarBank sb){
        instance = sb;
    }

    public static CreditCard[] getListCard(){
        return listCard;
    }



    public void startCreditCards() {
        //inicializa cartões de crédito

        for (CreditCard card:listCard) {
            card.setBalance(15000);
        }
    }

    public void roundCompleted(CreditCard card, double value) {
        //credita valor referente a cada rodada completa
        card.setBalance(card.getBalance() + value);
    }

    public boolean transfer(CreditCard payer, CreditCard receiver, double value) {
        boolean retorno = true;
        /*método responsável pela transferencia de um cartão para o outro.
         deve ter retorno boleano e retornar TRUE caso a transferencia for
        realizada e FALSE caso a transferencia não tenha sido realizada
        deve validar a excessão o metodo debitValue
        return ;*/
        try {
            payer.debitValue(value);
            receiver.creditValue(value);
        } catch (SaldoNegativoException e) {
            retorno= false;
            throw new RuntimeException(e);
        }
        return retorno;
    }

    public void receive(CreditCard card, double value) {

        card.creditValue(value);

    }

    public void pay(CreditCard card, double value) throws SaldoNegativoException {
        try {
            card.debitValue(value);
        } catch (SaldoNegativoException e) {
            throw new RuntimeException(e);
        }
    }

}
