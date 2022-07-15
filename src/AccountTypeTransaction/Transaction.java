package AccountTypeTransaction;

public class Transaction {
    int staticAccountNumber = 1111;
    int staticAccountPin = 111;
    float staticBalance = 200000.00F;

    protected int accountNumber;
    protected int accountPin;
    public String error;

    public String getError() {
       return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public boolean accountIsValid(){
        boolean accountNumberIsValid;
        boolean accountPinIsValid;

        if(this.accountNumber == staticAccountNumber){
            accountNumberIsValid = true;
        } else {
            accountNumberIsValid = false;
        }

        if(this.accountPin == staticAccountPin) accountPinIsValid = true;
        else accountPinIsValid = false;

        if (accountNumberIsValid) {
            if (!accountPinIsValid) {
                setError("Account Pin is Invalid");
                return false;
            } else {
                return true;
            }
        } else {
            setError("Account Number is Invalid");
            return false;
        }
    }

    public float getAccountBalance(){
        if(accountIsValid()){
            return staticBalance;
        } else {
            return  0;
        }
    }


    public String formatAmount(float amount){
        return "\u20B1";
    }

}
