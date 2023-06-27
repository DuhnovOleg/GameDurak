package ClientMenu;

import game.action.Action;
import game.action.ServerConnect;
import game.durak.Player;
import game.durak.Card;
import game.durak.GameTable;
import game.durak.Rules;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;


public class GamePlay extends javax.swing.JFrame 
{
    private static int round;      // Раунд игры
    
    private static Player    player    = new Player();
    private static GameTable gameTable = new GameTable();
    
    public GamePlay() 
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainPanel = new javax.swing.JPanel();
        jPanelPlayers = new javax.swing.JPanel();
        jReady = new javax.swing.JButton();
        jPanelRival = new javax.swing.JPanel();
        jgameTable = new javax.swing.JPanel();
        jGameHand = new javax.swing.JPanel();
        jDeck = new javax.swing.JPanel();
        jNumberCard = new javax.swing.JLabel();
        jBat = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1124, 900));
        setSize(new java.awt.Dimension(1124, 920));

        jMainPanel.setBackground(new java.awt.Color(8, 130, 45));
        jMainPanel.setPreferredSize(new java.awt.Dimension(900, 500));

        jPanelPlayers.setBackground(new java.awt.Color(8, 130, 45));
        jPanelPlayers.setForeground(new java.awt.Color(8, 130, 45));
        jPanelPlayers.setPreferredSize(new java.awt.Dimension(1117, 117));

        jReady.setBackground(new java.awt.Color(240, 243, 227));
        jReady.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jReady.setForeground(new java.awt.Color(22, 130, 45));
        jReady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReadyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPlayersLayout = new javax.swing.GroupLayout(jPanelPlayers);
        jPanelPlayers.setLayout(jPanelPlayersLayout);
        jPanelPlayersLayout.setHorizontalGroup(
            jPanelPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlayersLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jReady, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPlayersLayout.setVerticalGroup(
            jPanelPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPlayersLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jReady, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRival.setBackground(new java.awt.Color(8, 130, 45));

        javax.swing.GroupLayout jPanelRivalLayout = new javax.swing.GroupLayout(jPanelRival);
        jPanelRival.setLayout(jPanelRivalLayout);
        jPanelRivalLayout.setHorizontalGroup(
            jPanelRivalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRivalLayout.setVerticalGroup(
            jPanelRivalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        jgameTable.setBackground(new java.awt.Color(8, 130, 45));
        jgameTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jgameTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jgameTableMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jgameTableLayout = new javax.swing.GroupLayout(jgameTable);
        jgameTable.setLayout(jgameTableLayout);
        jgameTableLayout.setHorizontalGroup(
            jgameTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        jgameTableLayout.setVerticalGroup(
            jgameTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jGameHand.setBackground(new java.awt.Color(8, 130, 45));

        javax.swing.GroupLayout jGameHandLayout = new javax.swing.GroupLayout(jGameHand);
        jGameHand.setLayout(jGameHandLayout);
        jGameHandLayout.setHorizontalGroup(
            jGameHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jGameHandLayout.setVerticalGroup(
            jGameHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        jDeck.setBackground(new java.awt.Color(8, 130, 45));

        jNumberCard.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N

        javax.swing.GroupLayout jDeckLayout = new javax.swing.GroupLayout(jDeck);
        jDeck.setLayout(jDeckLayout);
        jDeckLayout.setHorizontalGroup(
            jDeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDeckLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jNumberCard, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jDeckLayout.setVerticalGroup(
            jDeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDeckLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jNumberCard, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jBat.setBackground(new java.awt.Color(8, 130, 45));

        javax.swing.GroupLayout jBatLayout = new javax.swing.GroupLayout(jBat);
        jBat.setLayout(jBatLayout);
        jBatLayout.setHorizontalGroup(
            jBatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jBatLayout.setVerticalGroup(
            jBatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jMainPanelLayout = new javax.swing.GroupLayout(jMainPanel);
        jMainPanel.setLayout(jMainPanelLayout);
        jMainPanelLayout.setHorizontalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRival, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPanelLayout.createSequentialGroup()
                .addComponent(jDeck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jgameTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jBat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jGameHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jMainPanelLayout.setVerticalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRival, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jMainPanelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jBat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPanelLayout.createSequentialGroup()
                        .addComponent(jDeck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addComponent(jgameTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGameHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1124, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jgameTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jgameTableMouseClicked
        Rules rules = new Rules();
        
        switch(player.getTurnOrder())
        {
            case 0:
            {
                showMessageDialog(jMainPanel, "Дождитесь своего ход!");
                break;
            }
            case 1:
            {
                int indexCard = -1;
                for (int i = 0; i < player.getNumberCard(); i++)
                {
                    if (player.getPressButton(i) == true)
                    {
                        indexCard = i;
                    }
                }
                
                if (indexCard == -1)
                {
                    showMessageDialog(jMainPanel, "Выберите карту!");
                }
                else
                {
                    boolean result = rules.PutCard(player.getCard(indexCard), gameTable);
                    if (result == true)
                    {
                        gameTable.addCardTable(player.getCard(indexCard));
                        addCardTable(player.getCard(indexCard), gameTable.getSize() - 1);
                        
                        try 
                        {
                            PutConnect(indexCard);
                        } 
                        catch (IOException ex) 
                        {
                            Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        player.poolCard(indexCard);
                        repaintGameHand(player.getNumberCard());
                        
                        if (player.getNumberCard() == 0 && player.getCardInDeck() == 0)
                        {
                            showMessageDialog(jMainPanel, "Вы выиграли!");
                            this.dispose();
                        }
                    }
                    else
                    {
                        showMessageDialog(jMainPanel, "Эту карту нельзя положить!");
                    }
                }
            }
        }
    }//GEN-LAST:event_jgameTableMouseClicked

    private void jReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReadyActionPerformed
        ServerConnect serverConnect = new ServerConnect();
        
        if (jReady.getText().equals("Бито"))
        {
            try
            {
                serverConnect.BeatCardSessionConnection(player.sessionToConnect, player.getUserName());
            }
            catch (IOException ex) 
            {
                Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
            }
            //player.setTurnOrder(0);
        }
        else if (jReady.getText().equals("Беру"))
        {
            player.setTurnOrder(0);
            ITakeConnectionThread myThread = new ITakeConnectionThread();
            myThread.start();
        }
    }//GEN-LAST:event_jReadyActionPerformed
    
    
    // Отправляет сообщение на сервер, какой картой походил игрок
    private void PutConnect(int indexCard) throws IOException
    {
        ServerConnect serverConnect = new ServerConnect();
        serverConnect.PutConnectServer(player.getSessionToConnect(), player.getUserName(), indexCard);
    }
    
    static FindConnectionThread findConnect = new FindConnectionThread();
    static boolean CheckStatusThread;
    // Отправка сообщения на сервер с целью получения изменения игрового стола
    private static void FindConnect()
    {
        findConnect.start();
    }
    
    private void addCardTable(Card card, Integer indexCard)
    {
        JButton jButton = addButton(card.pathInIcon, indexCard);
        //jButton.addActionListener(new ListenerAction());
        jgameTable.removeAll();
        jgameTable.repaint();
        
        
        switch(gameTable.getSize())
        {
            case 1:
            {
                jgameTable.add(jButton).setBounds(jgameTable.getWidth() / 2 - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                break;
            }
            case 2:
            {
                if (gameTable.getStatus(0) == true)
                {
                    JButton jprevButton1 = addButton(gameTable.getFlipCard(0).pathInIcon, 0);
                    JButton jprevButton2 = addButton(gameTable.getBrokenCard(0).pathInIcon, 0);
                    
                    jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 3 + 20 - 52, jgameTable.getHeight() / 2 + 20 - 149 / 2, 105, 149);
                    jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 3 - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                }
                else
                {
                    JButton jprevButton1 = addButton(gameTable.getFlipCard(0).pathInIcon, 0);
                    jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 3 - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                }
                
                jgameTable.add(jButton).setBounds(jgameTable.getWidth() / 3 + jgameTable.getWidth() / 3 - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                break;
            }
            case 3:
            {
                for (int i = 0; i < 2; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds((jgameTable.getWidth() / 4) * (i + 1) + 20 - 52, jgameTable.getHeight() / 2 + 20 - 149 / 2, 105, 149);
                        jgameTable.add(jprevButton1).setBounds((jgameTable.getWidth() / 4) * (i + 1) - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds((jgameTable.getWidth() / 4) * (i + 1) - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                    }
                }
                
                jgameTable.add(jButton).setBounds((jgameTable.getWidth() / 4) * 3 - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                break;
            }
            case 4:
            {
                for (int i = 0; i < 3; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 20, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                }
                
                jgameTable.add(jButton).setBounds(jgameTable.getWidth() / 2 - 52, 180, 105, 149);
                break;
            }
            case 5:
            {
                for (int i = 0; i < 3; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 20, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                }
                
                    if (gameTable.getStatus(3) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(3).pathInIcon, 3);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(3).pathInIcon, 3);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 3 + 20 - 52, 200, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 3 - 52, 180, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(3).pathInIcon, 3);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 3 - 52, 180, 105, 149);
                    }
                
                jgameTable.add(jButton).setBounds((jgameTable.getWidth() / 3) * 2 - 52, 180, 105, 149);
                break;
            }
            case 6:
            {
                for (int i = 0; i < 3; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 20, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                }
                
                for (int i = 0, j = 3; i < 2; i++, j++)
                {
                    if (gameTable.getStatus(j) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(j).pathInIcon, j);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(j).pathInIcon, j);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 200, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 180, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(j).pathInIcon, j);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 180, 105, 149);
                    }
                }
                
                jgameTable.add(jButton).setBounds((jgameTable.getWidth() / 4) * 3 - 52, 180, 105, 149);
                break;
            }
        }
    }
    
    private static void UpdateCardTable()
    {
        jgameTable.removeAll();
        jgameTable.repaint();
        switch(gameTable.getSize())
        {
            case 1:
            {
                if (gameTable.getStatus(0) == true)
                {
                    JButton jprevButton1 = addButton(gameTable.getFlipCard(0).pathInIcon, 0);
                    JButton jprevButton2 = addButton(gameTable.getBrokenCard(0).pathInIcon, 0);
                    
                    
                    jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 2 + 20 - 52, jgameTable.getHeight() / 2 + 20 - 149 / 2, 105, 149);
                    jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 2 - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                }
                else
                {
                    JButton jprevButton1 = addButton(gameTable.getFlipCard(0).pathInIcon, 0);
                    jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 2 - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                }
                break;
            }
            case 2:
            {
                for (int i = 0; i < 2; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds((jgameTable.getWidth() / 3) * (i + 1) + 20 - 52, jgameTable.getHeight() / 2 + 20 - 149 / 2, 105, 149);
                        jgameTable.add(jprevButton1).setBounds((jgameTable.getWidth() / 3) * (i + 1) - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds((jgameTable.getWidth() / 3) * (i + 1) - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                    }
                }
                break;
            }
            case 3:
            {
                for (int i = 0; i < 3; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, jgameTable.getHeight() / 2 + 20 - 149 / 2, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, jgameTable.getHeight() / 2 - 149 / 2, 105, 149);
                    }
                }
                break;
            }
            case 4:
            {
                for (int i = 0; i < 3; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 20, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                }
                
                if (gameTable.getStatus(3) == true)
                {
                    JButton jprevButton1 = addButton(gameTable.getFlipCard(3).pathInIcon, 3);
                    JButton jprevButton2 = addButton(gameTable.getBrokenCard(3).pathInIcon, 3);

                    jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 2 + 20 - 52, 200, 105, 149);
                    jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 2 - 52, 180, 105, 149);
                }
                else
                {
                    JButton jprevButton1 = addButton(gameTable.getFlipCard(3).pathInIcon, 3);
                    jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 2 - 52, 180, 105, 149);
                }
                break;
            }
            case 5:
            {
                for (int i = 0; i < 3; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 20, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                }
                
                for (int i = 0, j = 3; i < 2; i++, j++)
                {
                    if (gameTable.getStatus(j) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(j).pathInIcon, j);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(j).pathInIcon, j);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 3 * (i + 1) + 20 - 52, 200, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 3 * (i + 1) - 52, 190, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(j).pathInIcon, j);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 3 * (i + 1) - 52, 180, 105, 149);
                    }
                }
                break;
            }
            case 6:
            {
                for (int i = 0; i < 3; i++)
                {
                    if (gameTable.getStatus(i) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(i).pathInIcon, i);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 20, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(i).pathInIcon, i);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 0, 105, 149);
                    }
                }
                
                for (int i = 0, j = 3; i < 3; i++, j++)
                {
                    if (gameTable.getStatus(j) == true)
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(j).pathInIcon, j);
                        JButton jprevButton2 = addButton(gameTable.getBrokenCard(j).pathInIcon, j);

                        jgameTable.add(jprevButton2).setBounds(jgameTable.getWidth() / 4 * (i + 1) + 20 - 52, 200, 105, 149);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 180, 105, 149);
                    }
                    else
                    {
                        JButton jprevButton1 = addButton(gameTable.getFlipCard(j).pathInIcon, j);
                        jgameTable.add(jprevButton1).setBounds(jgameTable.getWidth() / 4 * (i + 1) - 52, 180, 105, 149);
                    }
                }
                break;
            }
        }
    }
    
    private static JButton addButton(String path, Integer indexCard)
    {
        JButton button = new JButton();
        button.setBounds(0, 0, 105, 149);
        button.setIcon(new ImageIcon(path));
        button.setActionCommand(indexCard.toString());

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        button.setCursor(cursor);
        button.addActionListener(new ButtonGameTable());

        return button;
    }
    
    // Старт игры. Здесь получаются изначальные данные о игровой сессии
    public static void StartGame(String m_userName, String m_sessionToConnection)
    {
        player.setUserName(m_userName);
        player.setSessionToConnect(m_sessionToConnection);
        
        try(Socket socket = new Socket("127.0.0.1", 8080))
        {
            try
                (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                )
            {
                writer.write(Action.SESSION_DATA_INITAL);
                writer.write(player.getUserName());
                writer.newLine();
                writer.write(player.getSessionToConnect());
                writer.newLine();
                writer.flush();
                
                String playerName = reader.readLine(); 
                while (!playerName.equals("NULL"))
                {
                    player.addPlayerNames(playerName);
                    playerName = reader.readLine(); 
                }
                if (player.getSizePlayerNames() != 6)
                {
                    Card card = new Card();
                    
                    card.nominals   = reader.readLine();
                    card.pathInIcon = reader.readLine();
                    card.suit       = reader.readLine();
                    card.power      = reader.read();
                    
                    player.setSuitTrump(card);
                }
                else
                {
                    Card card = new Card();
                    card.suit = reader.readLine();
                    player.setSuitTrump(card);
                }
                String nominals;
                while (true)
                {
                    Card card = new Card();
                    nominals = reader.readLine();
                    
                    if (nominals.equals("NULL"))
                        break;
                    
                    card.nominals   = nominals;
                    card.pathInIcon = reader.readLine();
                    card.suit       = reader.readLine();
                    card.power      = reader.read();
                    
                    player.addCard(card);
                }
                player.setCardInDeck(reader.read());
                player.setTurnOrder(reader.read());
            }
        }
        catch(IOException ex)
        {
            System.out.println("Подключение...");
            try 
            {
                Thread.sleep(500);
            } 
            catch(InterruptedException ie) {}
            StartGame(m_userName, m_sessionToConnection);
        }
        
        player.setNumberPlays(player.getSizePlayerNames());
        String args[] = null;
        main(args);
    }
    
    // Начальная инициализация интерфейса
    private static void InitStartum()
    {
        player.getIconPath();
        player.SortPlayers();
        
        switch(player.getNumberPlays())
        {
            case 2:
            {
                setPlayerIcon(player.getPlayerPathIcon(0), player.getPlayerNames(0), jPanelPlayers.getWidth() / 2);
                setRivalIcon(player.getPlayerPathIcon(1), player.getPlayerNames(1), jPanelRival.getWidth() / 2, 6);
                
                break;
            }
            case 3: case 4: case 5: case 6:
            {
                setPlayerIcon(player.getPlayerPathIcon(0), player.getPlayerNames(0), jPanelPlayers.getWidth() / 2);
                int positionIcon = jPanelRival.getWidth() / player.getNumberPlays();
                for (int i = 1, j = 0; i < player.getNumberPlays(); i++, j++)
                {
                    setRivalIcon(player.getPlayerPathIcon(i), player.getPlayerNames(i), positionIcon + positionIcon * j, 6);
                }
                break;
            }
        }
    }
    
    private static void setPlayerIcon(String pathIcon, String name, int widthIcon)
    {
        JLabel playerIcon = new JLabel(new ImageIcon(pathIcon));
        jPanelPlayers.add(playerIcon).setBounds(widthIcon, 0, 80, 80);
        
        JLabel playerName = new JLabel();
        playerName.setFont(new Font("Verdana", Font.PLAIN, 16));
        playerName.setText(name);
        jPanelPlayers.add(playerName).setBounds(widthIcon + 40 - (int)Math.ceil((double)name.length() / 2) * 8, 85, 120, 20);
    }
    
    private static void setRivalIcon(String pathIcon, String name, int widthIcon, int numberCard)
    {
        JLabel playerIcon = new JLabel(new ImageIcon(pathIcon));
        jPanelRival.add(playerIcon).setBounds(widthIcon, 0, 80, 80);
        
        JLabel playerName = new JLabel();
        playerName.setFont(new Font("Verdana", Font.PLAIN, 16));
        playerName.setText(name);
        jPanelRival.add(playerName).setBounds(widthIcon + 40 - (int)Math.ceil((double)name.length() / 2) * 8, 85, 120, 20);
        
        JLabel shirtRival = new JLabel(SelectedShirtRival(numberCard));
        jPanelRival.add(shirtRival).setBounds(widthIcon - 10, 110, 101, 74);
    }
   
    
    // Инициализация деки, руки игрока и рук противника
    private static void StartInitImage()
    {
        JLabel batIcon = new JLabel(new ImageIcon("../Game Durak/src/icon/deck/24card.png"));
        jDeck.add(batIcon).setBounds(10, 0, 113, 143);
        
        Card card = new Card();
        card = player.getCardSuitTrump();
        JLabel trampIcon = new JLabel(new ImageIcon(card.pathInIcon));
        jDeck.add(trampIcon).setBounds(17, 60, 100, 144);
        

        Integer cardInDeck = player.getCardInDeck();
        jNumberCard.setText(cardInDeck.toString());
        
        repaintGameHand(6);
        
        jReady.setVisible(false);
        if (player.getTurnOrder() == 1)
        {
            jReady.setText("Бито");
            showMessageDialog(jMainPanel, "Ваш ход!");
        }  
    }
    
    private static int repaintGameHand(int sizeHand)
    {
        jGameHand.removeAll();
        jGameHand.repaint();
        
        if (player.getNumberCard() == 0)
        {
            return 0;
        }
        
        int xlocation = jGameHand.getWidth() / sizeHand;
        for (Integer i = sizeHand - 1; i >= 0; i--)
        {
            Card initCard = new Card();
            initCard = player.getCard(i);
            
            ImageIcon imageIcon = new ImageIcon(initCard.pathInIcon);
            JButton jButton = new JButton();
            jButton.setBounds(0, 0, 105, 149);
            jButton.setIcon(imageIcon);
            jButton.setActionCommand(i.toString());
            
            Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
            jButton.setCursor(cursor);
            
            jButton.addActionListener(new ButtonGameHand());
            jGameHand.add(jButton).setBounds(xlocation * i, 3, 105, 149);
        }
        return 0;
    }
    
    private static ImageIcon SelectedShirtRival(int numberCard)
    {
        if (numberCard > 7)
        {
            numberCard = 7;
        }
        ImageIcon imageIcon = new ImageIcon("../Game Durak/src/icon/shirt/rival/" + numberCard + "card.png");
        return imageIcon;
    }
    
    static class ButtonGameHand implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            for (int i = 0; i < player.getSizeHand(); i++) 
            {
                player.setPressButton(false, i);
            }
            
            String action = e.getActionCommand();
            int indexCard = parseInt(action);
            player.setPressButton(true, indexCard);
            
            System.out.println("Нажатие кнопки! От - " + e.getActionCommand() + "\n");
        }
    }
    
    static class ButtonGameTable implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {    
            String action = e.getActionCommand();
            int indexCard = parseInt(action);
            
            int indexCardBeat = -1;
            for (int i = 0; i < player.getNumberCard(); i++)
            {
                if (player.getPressButton(i) == true)
                {
                    indexCardBeat = i;
                }
            }

            if (indexCardBeat == -1)
            {
                showMessageDialog(jMainPanel, "Выберите карту!");
            }
            switch(player.getTurnOrder())
            {
                case 0:
                {
                    showMessageDialog(jMainPanel, "Дождитесь своего хода!");
                    break;
                }
                case 1:
                {
                    showMessageDialog(jMainPanel, "Это сделать невозможно!");
                    break;
                }
                case 2:
                {
                    if (gameTable.getStatus(indexCard) == false)
                    {
                        Rules rules = new Rules();
                        ServerConnect serverConnect = new ServerConnect();
                        boolean result = rules.BeatCard(player.getCard(indexCardBeat), gameTable.getFlipCard(indexCard));
                        if (result == true)
                        {
                            gameTable.setStatus(indexCard, result);
                            gameTable.setBrokenCard(player.getCard(indexCardBeat), indexCard);
                            
                            while (CheckStatusThread != false);
                            
                            try 
                            {
                                synchronized(findConnect)
                                {
                                    findConnect.interrupt();
                                }
                                
                                serverConnect.ButConnectServer(player.getSessionToConnect(), player.getUserName(), indexCard, player.getCard(indexCardBeat), indexCardBeat);
                                
                                player.poolCard(indexCardBeat);
                                repaintGameHand(player.getNumberCard());
                                UpdateCardTable();
                                
                                synchronized(findConnect)
                                {
                                    findConnect.notify();
                                }
                            }
                            catch (IOException ex) 
                            {
                                Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else
                        {
                            showMessageDialog(jMainPanel, "Этой картой нельзя отбить!");
                        }
                    }
                    else
                    {
                        showMessageDialog(jMainPanel, "Эта карта уже отбита!");
                    }
                    break;
                }
            }
            
            System.out.println("Нажатие кнопки! От - " + e.getActionCommand() + "\n");
        }
    }
    
    static GameTable tempGameTable = new GameTable();
    static int prevRound;
    
    static class FindConnectionThread extends Thread
    {
        public void run()
        {
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException ie) {}
            ServerConnect serverConnect = new ServerConnect();
            while (true)
            {
                CheckStatusThread = true;
                GameTable newGameTable = new GameTable();
                newGameTable = serverConnect.FindConnectServer(player.getSessionToConnect(), player.getUserName());
                if (CheckGameTable(newGameTable) == true)
                {
                    player.setTurnOrder(serverConnect.turnOrder);
                    
                    if (player.getTurnOrder() == 1)
                    {
                        jReady.setText("Бито");
                        jReady.setVisible(true);
                    }
                    else if (player.getTurnOrder() == 2)
                    {
                        jReady.setText("Беру");
                        jReady.setVisible(true);
                    }
                    
                    gameTable     = newGameTable;
                    if (gameTable.getSize() != 0)
                    {
                        tempGameTable = gameTable;
                    }
                    UpdateCardTable();
                }
                
                //if (newGameTable.checkTakePlayer != 0)
                //{
                    player.setTurnOrder(serverConnect.turnOrder);
                    
                    if (player.getTurnOrder() == 1)
                    {
                        jReady.setText("Бито");
                        jReady.setVisible(true);
                    }
                //}
                
                if ((gameTable.getSize() == 0 || CheckForRepulsed() == false) && newGameTable.checkTakePlayer == 0)
                {
                    if (player.getTurnOrder() == 1)
                    {
                        jReady.setVisible(false);
                    }
                }
                if (gameTable.getSize() == 0 || CheckForRepulsed() == true)
                {
                    if (player.getTurnOrder() == 2)
                    {
                        jReady.setVisible(false);
                    }
                }
                
                round = serverConnect.round;
                if (prevRound != round)
                {
                    Player prevPlayer = new Player();
                    //prevPlayer = player;
                    
                    prevPlayer.setPlayerCard(serverConnect.UpdateDataSessionConnection(player.sessionToConnect, player.getUserName()));
                    if (prevPlayer.getNumberCard() != 0)
                    {
                        player.setPlayerCard(prevPlayer.getPlayerCard());
                    }

                    player.setTurnOrder(serverConnect.turnOrder);
                    player.setCardInDeck(serverConnect.numberCards);
                    Integer numberCardInDeck = serverConnect.numberCards;
                    //int check = serverConnect.check;
                    
                    jNumberCard.setText(numberCardInDeck.toString());
                    repaintGameHand(player.getNumberCard());
                    jReady.setVisible(false);
                    
                    serverConnect.check = 0;
                    
                    if (player.getTurnOrder() == 1)
                    {
                        showMessageDialog(jMainPanel, "Ваш ход!");
                    }
                }
                prevRound = round;
                
                CheckStatusThread = false;
                try
                {
                    Thread.sleep(500);
                } 
                catch(InterruptedException ie) {}
            }
        }
    }
    
    
    private static boolean CheckForRepulsed()
    {
        for (int i = 0; i < gameTable.getSize(); i++)
        {
            if (gameTable.getStatus(i) == false)
            {
                return false;
            }
        }
        return true;
    }
    
    static class ITakeConnectionThread extends Thread
    {
        public void run()
        {
            try
            {
                Thread.sleep(500);
            } 
            catch(InterruptedException ie) {}
            ServerConnect serverConnect = new ServerConnect();
            boolean result = false;
            while (result != true)
            {
                while (CheckStatusThread == true);
                try 
                {
                    synchronized(findConnect)
                    {
                        findConnect.interrupt();
                    }
                    result = serverConnect.ITakeSessionConnect(player.sessionToConnect, player.getUserName());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
                }
                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException ie) {}
            }
            for (int i = 0; i < tempGameTable.getSize(); i++)
            {
                if (tempGameTable.getStatus(i) == true)
                {
                    player.addCard(tempGameTable.getFlipCard(i));
                    player.addCard(tempGameTable.getBrokenCard(i));
                }
                else
                {
                    player.addCard(tempGameTable.getFlipCard(i));
                }
            }
//            tempGameTable.ClearTable();
            repaintGameHand(player.getSizeHand());
            jgameTable.removeAll();
            jgameTable.repaint();
            
            synchronized(findConnect)
            {
                findConnect.notify();
            }
        }
    }
    
    private static boolean CheckGameTable(GameTable newGameTable)
    {
        if (newGameTable.getSize() != gameTable.getSize())
        {
            return true;
        }
        for (int i = 0; i < gameTable.getSize(); i++)
        {
            if (gameTable.getStatus(i) != newGameTable.getStatus(i))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(GamePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new GamePlay().setVisible(true);
                InitStartum();
                StartInitImage();
                FindConnect();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel jBat;
    private static javax.swing.JPanel jDeck;
    private static javax.swing.JPanel jGameHand;
    private static javax.swing.JPanel jMainPanel;
    private static javax.swing.JLabel jNumberCard;
    private static javax.swing.JPanel jPanelPlayers;
    private static javax.swing.JPanel jPanelRival;
    private static javax.swing.JButton jReady;
    private static javax.swing.JPanel jgameTable;
    // End of variables declaration//GEN-END:variables
}
