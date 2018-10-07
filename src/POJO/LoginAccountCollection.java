package POJO;

import java.util.ArrayList;

public class LoginAccountCollection {
    private ArrayList<LoginAccount> loginAccounts;

    public LoginAccountCollection(){
        this.loginAccounts = new ArrayList<>();
    }

    /** Add a new LoginAccount object to the collection.
     * There can only be one type of username. No copies. */
    public boolean add(LoginAccount accountToAdd){
        // did it work?
        boolean answer = true;

        for(LoginAccount account : loginAccounts){
            // is there a copy of the username?
            if(account.getUsername().toLowerCase().equals(accountToAdd.getUsername().toLowerCase())){
                answer = false;
            }
        }
        return answer;
    }

    /** Remove a LoginAccount */
    public boolean remove(LoginAccount acocuntToRemove){
        boolean removed = false;
        for(int i = 0, length = loginAccounts.size(); i < length; i++){
            if(loginAccounts.get(i).getUsername().toLowerCase().equals(acocuntToRemove.getUsername().toLowerCase())){
                loginAccounts.remove(i); // remove that object
                removed = true;
            }
        }
        return removed; // return if it was removed or not
    }

    /** Looks for a LoginAccount. Returns null if one is not found */
    public LoginAccount findAccount(LoginAccount accountToLookFor){
        LoginAccount accountToReturn = null;

        for(LoginAccount account : loginAccounts){
            if(account.getUsername().toLowerCase().equals(accountToLookFor.getUsername().toLowerCase())){
                accountToReturn = account;
            }
        }
        return accountToReturn;
    }
}
