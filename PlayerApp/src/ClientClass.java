
import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JList;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ClientClass extends UnicastRemoteObject implements ClientInterface
{
    JFrame jFrame;
    JList l;
    JTextArea area,area2;
    JButton question, trick, answer, exit, talk;
    ClientClass(JList l,JTextArea area, JTextArea area2, JButton question, JButton trick, JButton answer, JButton exit, JButton talk, JFrame jFrame)throws RemoteException
    {
        super();
        this.l=l;
        this.area=area;
        this.area2=area2;
        this.question=question;
        this.trick=trick;
        this.answer=answer;
        this.exit=exit;
        this.talk=talk;
        this.jFrame=jFrame;
    }
    public void refreshArea(String msg)throws RemoteException
    {
        area.append(msg);
        area.setCaretPosition(area.getDocument().getLength());
    }
    public void refreshArea2(String msg)throws RemoteException
    {
        area2.append(msg+"\n");
        area2.setCaretPosition(area2.getDocument().getLength());
    }

    @Override
    public void refreshList(Vector<String> names) throws RemoteException {
        //Collections.sort(names);
        l.setListData(names);
    }

    @Override
    public void disableButton(String task) throws RemoteException {
        //To change body of generated methods, choose Tools | Templates.
        if(task.equals("question")){
        question.setEnabled(false);
        exit.setEnabled(false);
        trick.setEnabled(true);
        }
        else if(task.equals("tricks_done"))
        {
            answer.setEnabled(true);
            //trick.setEnabled(false);
        }
        else if(task.equals("answers_done")){
            //answer.setEnabled(false);
            question.setEnabled(true);
            exit.setEnabled(true);
        }
        else if(task.equals("all")){
            /*l.setEnabled(false);
            area.setEnabled(false);
            area2.setEnabled(false);
            question.setEnabled(false);
            trick.setEnabled(false);
            answer.setEnabled(false);
            talk.setEnabled(false);
            exit.setEnabled(false);*/
            new CLIENT().setVisible(true);
        }
    }

    @Override
    public void clearArea() throws RemoteException {
       area.setText("");
    }

    @Override
    public void answerStatus(String msg) throws RemoteException {
        area.append(msg);
        area.setCaretPosition(area.getDocument().getLength());
    }

    @Override
    public synchronized void setArea(String msg) throws RemoteException {
        System.out.println("inside setArea") ;
        this.area.append(msg);
        this.area.setCaretPosition(this.area.getDocument().getLength());
        System.out.println("done setArea") ;
    }   
    
    @Override
    public void setFontColor(Color c) throws RemoteException{
        area.setForeground(c);
    }
    
    @Override
    public void enableExit() throws RemoteException{
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
