
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface 
        extends Remote
{
    public void registerUser(ClientInterface ci,
            String name)
            throws RemoteException;
    public void removeUser(String name)
            throws RemoteException;
    public void sendMessage(String msg)throws RemoteException;
    public void sendMessageLive(String msg)throws RemoteException;
    public int getUsersCount()throws RemoteException;
    public int getCorrectCount(String name) throws RemoteException;
    public String getCorrectAns() throws RemoteException;
    public void sendEnd() throws RemoteException;
}
