
package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Mai146607
 */
public interface ComplaintInterface extends Remote {
        public void giveComplaint(Account acc ,String str) throws RemoteException;
}
