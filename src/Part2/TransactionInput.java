package Part2;

/**
 * TranscationInput은 앞서 있는 TransactionOutput을 가져온다.
 * 즉, 이 부분에서 해당 Output값이 있는지 체크하는 용도로 사용이 된다.
 */
public class TransactionInput {
    // TransactionOutputs -> transactionId
    public String transactionOutputId;
    //Unspent transaction output
    public TransactionOutput UTXO;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}
