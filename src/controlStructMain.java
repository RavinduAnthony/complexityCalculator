

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class controlStructMain extends javax.swing.JFrame {
        int i =0;
        int j = 0;
        int ctc =0;
        List<String> outputArray = new ArrayList<>(); //String array of all the lines and count
        List<Integer> countArray = new ArrayList<>(); //Integer array of line by line count   
    
    public controlStructMain() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        importTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        importTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Programe Statemnet", "Ctc"
            }
        ));
        jScrollPane1.setViewportView(importTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    public static void main(String args[]) {
              
        controlStructMain cm = new controlStructMain();
        cm.calculateControlStructures();
          
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new controlStructMain().setVisible(true);
            }
        });
    }
    
    public void calculateControlStructures(){
        try {
            
            List<String> alllines = Files.readAllLines(Paths.get("C:\\Users\\Asus\\Desktop\\switchCase.txt"));
            
            for(java.util.Iterator<String> iterator = alllines.iterator(); iterator.hasNext();){
                String i = iterator.next();
                if(i.trim().isEmpty()|| i.trim().startsWith("/*")||i.trim().startsWith("//")||
                        i.trim().startsWith("*")||i.trim().startsWith("import")||i.trim().contains("class")||i.trim().contains("\"")){
                      iterator.remove();
                }
            }
            
            for(String line : alllines){
                    int lineLen = line.length();
                line = line.replaceAll("\\s+", "");
                
                System.out.println(line);
                 //System.out.println(line);
                char [] lineChar;
                    
                    //count if count
                    if(line.contains("if")){
                                                
                        lineChar = line.toCharArray();
                        int arrayLen = lineChar.length;
                                              
                        
                        for(i=0; i<arrayLen; i++){
                            if('i' == lineChar[i] && 'f' == lineChar[i+1] && '(' == lineChar[i+2]){
                                ctc = ctc+1;
                            }
                            if('&' == lineChar[i] && '&' == lineChar[i+1]){
                                   ctc = ctc+1;
                                }
                            else if('|' == lineChar[i] && '|' == lineChar[i+1]){
                                   ctc = ctc+1;
                            }    
                                                                                                    
                        }
                        
                                                                        
                    }
                    
                    //count while count
                    else if(line.contains("while")){
                        lineChar = line.toCharArray();
                        int arrayLen = lineChar.length;
                                            
                        
                        for(i=0; i<arrayLen; i++){
                            
                            if('w' == lineChar[i] && 'h' == lineChar[i+1] && 'i' == lineChar[i+2] && 'l' == lineChar[i+3] && 'e' == lineChar[i+4] && '{' == lineChar[lineChar.length -1]){
                                ctc = ctc+2;
                            }
                            if('&' == lineChar[i] && '&' == lineChar[i+1]){
                                   ctc = ctc+2;
                                }
                            else if('|' == lineChar[i] && '|' == lineChar[i+1]){
                                   ctc = ctc+2;
                            } 
                        }
                        
                        //count whole weight of while loops
                       // whileContWeight = (whileCount + wAndCount + wOrCount);
                        
                    }
                    
                    //count switch-case count
                    else if(line.contains("case")){
                        ctc = ctc+1;               
                    }
                    
                    //count try-catch count
                    else if(line.contains("catch")){
                                                
                        lineChar = line.toCharArray();
                        int arrayLen = lineChar.length;
                        
                        for(i=0; i<arrayLen; i++){
                            if('c' == lineChar[i] && 'a' == lineChar[i+1] && 't' == lineChar[i+2] && 'c' == lineChar[i+3] && 'h' == lineChar[i+4] && '(' == lineChar[i+5]){
                               ctc = ctc+1;
                            }
                        }
                    }
                    
                    //count do-while count
                    else if(line.contains("do")){
                                                
                        lineChar = line.toCharArray();
                        int arrayLen = lineChar.length;
                        
                        for(i=0; i<arrayLen; i++){
                            if('d' == lineChar[i] && 'o' == lineChar[i+1] && '{' == lineChar[i+2]){
                                ctc = ctc+2;
                            }
                            if('&' == lineChar[i] && '&' == lineChar[i+1]){
                                   ctc = ctc+2;
                                }
                            else if('|' == lineChar[i] && '|' == lineChar[i+1]){
                                   ctc = ctc+2;
                            } 
                        }
                                               
                        //count whole weight of do-while loops
                        //doContWeight = (dowhile + dAndCount + dOrCount);
                    }  
                    
                    
                    //count for loops count
                    else if(line.contains("for")){
                                                
                        lineChar = line.toCharArray();
                        int arrayLen = lineChar.length;
                                                
                        for(i=0; i<arrayLen; i++){
                            if('f' == lineChar[i] && 'o' == lineChar[i+1] && 'r' == lineChar[i+2] && '(' == lineChar[i+3]){
                               ctc = ctc+2;
                            }
                            if('&' == lineChar[i] && '&' == lineChar[i+1]){
                                   ctc = ctc+2;
                                }
                            else if('|' == lineChar[i] && '|' == lineChar[i+1]){
                                   ctc = ctc+2;
                            } 
                             
                        }
                                                
                    }
                    
                    outputArray.add(line + "                    "+Integer.toString(ctc));
                        for(String out : outputArray){
                            System.out.println(out);
                        }
            
                    countArray.add(ctc);
                          ctc = 0;
                 
                        System.out.println(countArray);
                      
            }
                            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    public Object[] printCountArray(){
        System.out.println(countArray);
        return countArray.toArray();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable importTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
