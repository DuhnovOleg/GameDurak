package ClientMenu;
import game.action.Action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class GameStart extends javax.swing.JFrame 
{
    private static String  userName;
    private static String  sessionToConnect;
    private static boolean visible = true;
    public GameStart() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        javax.swing.JLabel Banner = new javax.swing.JLabel();
        SearchGame = new javax.swing.JButton();
        CreateGame = new javax.swing.JButton();
        ExitGame = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        namePlayer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(47, 115, 62));

        Banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/banner.png"))); // NOI18N
        Banner.setText("jLabel1");

        SearchGame.setBackground(new java.awt.Color(47, 115, 62));
        SearchGame.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        SearchGame.setForeground(new java.awt.Color(255, 255, 255));
        SearchGame.setText("Найти игру");
        SearchGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchGameActionPerformed(evt);
            }
        });

        CreateGame.setBackground(new java.awt.Color(47, 115, 62));
        CreateGame.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        CreateGame.setForeground(new java.awt.Color(255, 255, 255));
        CreateGame.setText("Создать игру");
        CreateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateGameActionPerformed(evt);
            }
        });

        ExitGame.setBackground(new java.awt.Color(47, 115, 62));
        ExitGame.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        ExitGame.setForeground(new java.awt.Color(255, 255, 255));
        ExitGame.setText("Выйти из игры");
        ExitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitGameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setText("ДУРАК");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 2, 24)); // NOI18N
        jLabel2.setText("Карточная Игра");

        namePlayer.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        namePlayer.setText("Пользователь:");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addComponent(namePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Banner, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(227, 227, 227))))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExitGame)
                    .addComponent(CreateGame, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchGame, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(Banner, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(SearchGame)
                .addGap(57, 57, 57)
                .addComponent(CreateGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(ExitGame)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateGameActionPerformed
        sessionToConnect     = JOptionPane.showInputDialog("Введите имя игровой сессии, которую хотите создать:");
        String numberPlayers = JOptionPane.showInputDialog("Введите количество игроков:");
        
        try (Socket socket = new Socket("127.0.0.1", 8080);)
        {
            try
                (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));   // Принимает пакеты (читает)
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Отправляет пакеты (записывает)
                )
            {
                //
                // Отправка на сервер запроса на создание игровой сессии
                // Отправляем имя игрока, имя сессии и кол-ва игроков на сессии
                //
                writer.write(Action.CREATE_GAME);
                writer.write(userName);
                writer.newLine();
                writer.write(sessionToConnect);
                writer.newLine();
                writer.write(Integer.valueOf(numberPlayers));
                writer.newLine();
                writer.flush();

                String info = null;

                while (info == null)
                {
                    info = reader.readLine();
                    try 
                    {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println(info);
                       
                WaitingConnectionThread waitingConnection = new WaitingConnectionThread();
                waitingConnection.start();
                
                JOptionPane.showMessageDialog(MainPanel, "Пожалуйста, дождитесь подключения остальных игроков!");
                while(visible == true)
                {
                    try 
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                setVisible(false);
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CreateGameActionPerformed

    private void SearchGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchGameActionPerformed
        sessionToConnect = JOptionPane.showInputDialog("Введите имя игровой сессии, куда хотите подключиться:");
        
        try (Socket socket = new Socket("127.0.0.1", 8080))
        {
            try
                (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));   // Принимает пакеты (читает)
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Отправляет пакеты (записывает)    
                )
            {
                writer.write(Action.CONNECT_SESSIONS);
                writer.write(userName);
                writer.newLine();
                writer.write(sessionToConnect);
                writer.newLine();
                writer.flush();
                
                String info = null;
                while (info == null)
                {
                    info = reader.readLine();
                    try 
                    {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println(info);
                 

                WaitingConnectionThread waitingConnection = new WaitingConnectionThread();
                waitingConnection.start();
                
                JOptionPane.showMessageDialog(MainPanel, "Пожалуйста, дождитесь подключения остальных игроков!");
                
                while(visible == true)
                {
                    try 
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                setVisible(false);
            }
        } 
        catch (IOException ex)
        {
            Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchGameActionPerformed

    private void ExitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitGameActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExitGameActionPerformed
 
    // Ожидание подключения к игровой сессии
    private void WaitingConnection() throws IOException
    {
        String connectionStatus = null;
        while(!"Подключение".equals(connectionStatus))
        {
            try(Socket socket = new Socket("127.0.0.1", 8080))
            {
                try
                (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));   // Принимает пакеты (читает)
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Отправляет пакеты (записывает)    
                )
                {
                    writer.write(Action.WAITING_CONNECTION);
                    writer.write(sessionToConnect);
                    writer.newLine();
                    writer.flush();
                    try 
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    connectionStatus = reader.readLine();
                    System.out.println(connectionStatus);
                }
            }
        }
        String[] args = null;
        GamePlay.StartGame(userName, sessionToConnect);
        visible = false;
        //setVisible(false);
    }
    
    class WaitingConnectionThread extends Thread
    {
        public void run()
        {
            try
            {
                WaitingConnection();
            } 
            catch (IOException ex)
            {
                Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new GameStart().setVisible(true);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameStart.class.getName()).log(Level.SEVERE, null, ex);
                }
                userName = JOptionPane.showInputDialog("Введите своё имя:");
                namePlayer.setText("Пользователь: " + userName);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateGame;
    private javax.swing.JButton ExitGame;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton SearchGame;
    private static javax.swing.JLabel namePlayer;
    // End of variables declaration//GEN-END:variables
}
