
import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface ClientInterface extends Remote
{
    public void refreshList(Vector<String> names)throws RemoteException;
    public void refreshArea(String msg)throws RemoteException;
    public void setArea(String msg)throws RemoteException;
    public void refreshArea2(String msg)throws RemoteException;
    public void disableButton(String task)throws RemoteException;
    public void clearArea()throws RemoteException;
    public void answerStatus(String msg)throws RemoteException;
    public void setFontColor(Color c) throws RemoteException;
    public void enableExit() throws RemoteException;
}
