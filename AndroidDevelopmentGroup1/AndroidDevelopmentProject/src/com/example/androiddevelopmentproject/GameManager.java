package com.example.androiddevelopmentproject; 
  
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List; 
  
import android.util.Pair; 
  
enum ProbablePlayerLevel { First, Second, Third, Fourth} 
  
public class GameManager { 
    private ArrayList<Player> _players; 
    private ArrayList<MatchBeker> allBekerMatches; 
    private ArrayList<MatchKroongroup> allKroonGroupMatches; 
    ArrayList<Player> myPairedPlayers;
    ArrayList<Player> allNotPairedPlayers;
    public GameManager(ArrayList<Player> player, ArrayList<MatchBeker> baker, ArrayList<MatchKroongroup> kroongroup) { 
        _players = new ArrayList<Player>();
        allBekerMatches = new ArrayList<MatchBeker>();
        allKroonGroupMatches = new ArrayList<MatchKroongroup>();
        _players = player;
        allBekerMatches = baker;
        allKroonGroupMatches = kroongroup;
    } 
  
    private ArrayList<MatchBeker> GetAllBekerMatches() { 
       
        return this.allBekerMatches; 
  
    } 
  
    private ArrayList<MatchBeker> GetBekerMatches(Player p1, Player p2) { 
        ArrayList<MatchBeker> bekerMatches = new ArrayList<MatchBeker>(); 
        for (MatchBeker b : GetAllBekerMatches()) { 
            if ((b.playerIdBlack.contains(p1.id) && b.playerIdWhite.contains(p2.id)) 
                    || (b.playerIdBlack.contains(p2.id) && b.playerIdWhite.contains(p1.id))) 
                bekerMatches.add(b); 
        } 
        return bekerMatches; 
    } 
  
    private ArrayList<MatchKroongroup> GetAllKroongroupMatches() { 
        
        return this.allKroonGroupMatches; 
    } 
  
    private ArrayList<MatchKroongroup> GetKroongroupMatches(Player p1, Player p2) { 
        ArrayList<MatchKroongroup> kroonGroupMatches = new ArrayList<MatchKroongroup>(); 
        for (MatchKroongroup kg : GetAllKroongroupMatches()) { 
            if ((kg.playerIdBlack.contains(p1.id) && kg.playerIdWhite.contains(p2.id)) 
                    || (kg.playerIdBlack.contains(p2.id) && kg.playerIdWhite.contains(p1.id))) 
                kroonGroupMatches.add(kg); 
        } 
        return kroonGroupMatches; 
    } 
  
    private Boolean CheckBekerMatch(Player p1, Player p2, int count) { 
        if (GetBekerMatches(p1, p2).size() >= count) 
            return true; 
        return false; 
    } 
  
    private Boolean CheckKroonGroupMatch(Player p1, Player p2, int count) { 
        if (GetKroongroupMatches(p1, p2).size() >= count) 
            return true; 
        return false; 
    } 
  
    private ArrayList<Player> GetAllPlayers() { 
  
        return _players; 
    } 
  
    // player who is going to play next 
    public ArrayList<Player> GetPairedPlayers(Player player) { 
         myPairedPlayers = new ArrayList<Player>(); 
  
         allNotPairedPlayers = GetNotPairedPlayers(); 
        Collections.sort(allNotPairedPlayers); 
         // System.out.println("Players in the Gamemager class"+allNotPairedPlayers);
      
        /* 
         * Player tempPlayer = null; int counter = 0; 
         *  
         * // if we have odd then the player will not be in paired for (Player p 
         * : allPlayingPlayers)// looking at all the sort players // with rating 
         * { counter++; if (counter == 2) { Pair<Player, Player> newPair = new 
         * Pair<Player, Player>( tempPlayer, p); pairedTwoPlayer.add(newPair); 
         * counter = 0; } else tempPlayer = p; } for (Pair<Player, Player> pair 
         * : pairedTwoPlayer) { if (pair.first.id == player.id) 
         * pairedPlayers.add(pair.second); else if (pair.second.id == player.id) 
         * pairedPlayers.add(pair.first); } 
         */
          
        //get all paired list 
        ArrayList<Pair<Player, Player>> allPairedPlayers=ComputePlayerPairing(allNotPairedPlayers); 
        //Check if manually paired 
        //System.out.println("allPairedPlayers "+allPairedPlayers);
        Player firstProbablePlayer=GetManuallyPairedPlayer(player); 
       // System.out.println("firstProbablePlayer "+firstProbablePlayer);
        int chanceWin=0; 
        if(firstProbablePlayer!=null) 
        { 
            firstProbablePlayer.setOdd(90); 
            myPairedPlayers.add(firstProbablePlayer); 
        } 
        else
        { 
            for (Pair<Player, Player> pair  : allPairedPlayers)  
            {  
                if (pair.first.id.contains(player.id)) {
                    firstProbablePlayer=pair.second; 
                    int diff = pair.second.currentRating - player.currentRating; 
                    System.out.println(pair.second.currentRating+" - +"+player.currentRating);
                    System.out.println("diff "+diff);
                    double ExpectationPower = diff/400.0;
                    System.out.println("ExpectationPower: "+ExpectationPower);
                    double ExpectationPowerTo = Math.pow(10, ExpectationPower);
                    System.out.println("ExpectationPowerto: "+ExpectationPowerTo);
                     double winExpectation = 1 / (1 + ExpectationPowerTo);
                     chanceWin = (int) (winExpectation * 100);
                     System.out.println("chanceWin: "+chanceWin);
                    System.out.println("firstProbablePlayer in if "+firstProbablePlayer);
                    //break;
                    
                }
                
                else if (pair.second.id.contains(player.id)) {
                    firstProbablePlayer=pair.first;  
                    int diff = pair.first.currentRating - player.currentRating; 
                    double ExpectationPower = diff/400.0;
                    double ExpectationPowerTo = Math.pow(10, ExpectationPower);
                     double winExpectation = 1 / (1 + ExpectationPowerTo);
                     chanceWin = (int) (winExpectation * 100);
                    System.out.println("firstProbablePlayer in else if "+firstProbablePlayer);
                }
            } 
            
            firstProbablePlayer.setOdd(90); 
            firstProbablePlayer.setWinchance(chanceWin);//calculate with first probable player
            myPairedPlayers.add(firstProbablePlayer); 
            System.out.println("myPairedPlayers out if "+myPairedPlayers);
            Player secondProbablePlayer=GetProbablePlayer(allPairedPlayers, player, ProbablePlayerLevel.Second); 
            secondProbablePlayer.setOdd(80); 
            if(secondProbablePlayer!=null) 
                myPairedPlayers.add(secondProbablePlayer); 
            System.out.println("secondProbablePlayer in else if "+secondProbablePlayer);
              
            Player thirdProbablePlayer=GetProbablePlayer(allPairedPlayers, player, ProbablePlayerLevel.Third); 
            System.out.println("thirdProbablePlayer "+thirdProbablePlayer);
            thirdProbablePlayer.setOdd(70); 
            if(thirdProbablePlayer!=null) 
                myPairedPlayers.add(thirdProbablePlayer); 
            System.out.println("thirdProbablePlayer in else if "+thirdProbablePlayer);
        } 
        System.out.println("all ProbablePlayer in  secondif "+myPairedPlayers);
        return myPairedPlayers; 
          
    } 
      
    private Player GetProbablePlayer(ArrayList<Pair<Player, Player>> pairedPlayers, Player player, ProbablePlayerLevel probabilityLevel) 
    { 
        Player probablePlayer=null; 
        Pair<Player, Player> possiblePair; 
        if(probabilityLevel==ProbablePlayerLevel.First) 
        {} 
          
        else if(probabilityLevel==ProbablePlayerLevel.Second) //assuming if my opponent will not participate 
        { 
            for (Pair<Player, Player> pair  : pairedPlayers)  
            {  
                int mm=GetIndexOfMyPair(pairedPlayers,player); 
                  
                    if (pair.first.id.contains(player.id) || pair.second.id.contains(player.id)) 
                    { 
                        if(pairedPlayers.size()>(GetIndexOfMyPair(pairedPlayers,player)+1)) 
                        { 
                            possiblePair=pairedPlayers.get(GetIndexOfMyPair(pairedPlayers,player)+1); //next pair 
                           // System.out.println("second ProbablePlayer in  secondif "+possibleP//calculate possiblility with second possible player winning   
                            int diff = possiblePair.first.currentRating - player.currentRating; 
                            double ExpectationPower = diff/400.0;
                            double ExpectationPowerTo = Math.pow(10, ExpectationPower);
                             double winExpectation = 1 / (1 + ExpectationPowerTo);
                             int chanceWin = (int) (winExpectation * 100);
                            possiblePair.first.setWinchance(chanceWin);
                            return possiblePair.first; 
                        } 
                    } 
            } 
        } 
        else if(probabilityLevel==ProbablePlayerLevel.Third) //assuming upper pair first player will not participate 
        { 
            for (Pair<Player, Player> pair  : pairedPlayers)  
            {  
                    if (pair.first.id.contains(player.id) || pair.second.id.contains(player.id)) 
                    { 
                    	
                        if(pairedPlayers.size()>(GetIndexOfMyPair(pairedPlayers,player)+2)) 
                        { 
                            possiblePair=pairedPlayers.get(GetIndexOfMyPair(pairedPlayers,player)+2); 
                            //calculate possiblility with third possible player winning  
                            int diff = possiblePair.second.currentRating - player.currentRating; 
                            double ExpectationPower = diff/400.0;
                            double ExpectationPowerTo = Math.pow(10, ExpectationPower);
                             double winExpectation = 1 / (1 + ExpectationPowerTo);
                             int chanceWin = (int) (winExpectation * 100);
                            possiblePair.second.setWinchance(chanceWin);
                            return possiblePair.second; 
                        } 
                    } 
            } 
        } 
        return probablePlayer; 
          
      
    } 
      
    private int GetIndexOfMyPair(ArrayList<Pair<Player, Player>> pairedPlayerList,Player player) 
    { 
    	
        int myindex=0; 
        for (Pair<Player, Player> pair  : pairedPlayerList)  
        { 
            if (pair.first.id.contains(player.id) || pair.second.id.contains(player.id)) 
            { 
                return myindex; 
            } 
            myindex++; 
        } 
        return myindex; 
    } 
  
    private ArrayList<Pair<Player, Player>> ComputePlayerPairing(ArrayList<Player> players)  
    { 
        ArrayList<Pair<Player, Player>> playerPairs = new ArrayList<Pair<Player, Player>>(); 
        ArrayList<Player> playersInPair = new ArrayList<Player>(); 
          
        for (Player p : players)  
        { 
            if (!playersInPair.contains(p))  
            {    
                for(Player opponent: players) 
                { 
                        if(!playersInPair.contains(opponent) && !p.id.contains(opponent.id)) 
                        { 
                            Boolean isBekerMatchCompleted = CheckBekerMatch(p, opponent, 5); 
                            Boolean isKroonMatchCompleted = CheckKroonGroupMatch(p, opponent, 5); 
                            if (!isBekerMatchCompleted || !isKroonMatchCompleted) 
                            { 
                                Pair<Player, Player> newPair = new Pair<Player, Player>(p, opponent); 
                                playerPairs.add(newPair); 
                                playersInPair.add(p); 
                                playersInPair.add(opponent); 
                                break; 
                            }                            
                        } 
                } 
            } 
  
        } 
        return playerPairs; 
  
    } 
  
    // players pairing 
    public ArrayList<Player> GetFinalPairing(Player player) { 
        ArrayList<Player> pairedPlayers = new ArrayList<Player>(); 
  
        ArrayList<Player> allPlayingPlayers = GetNotPairedPlayers(); 
        Collections.sort(allPlayingPlayers); 
  
        return pairedPlayers; 
    } 
  
    // Logged in player 
    public Player GetPlayer(Player logginPlayer) { 
        return logginPlayer;
    } 
    
 // Logged in player 
    public Player GetPlayerById(String id) { 
        for (Player p : GetAllPlayers()) { 
            if (p.id.contains(id)) { 
                return p; 
            } 
  
        } 
        return null; 
    }
  
    // player playing players in next round without manualpairing 
    private ArrayList<Player> GetNotPairedPlayers() { 
        ArrayList<Player> notPairedPlayers = new ArrayList<Player>(); 
        for (Player p : GetAllPlayers())  
        { 
            if ( p.nextPairing.isEmpty()) { 
                notPairedPlayers.add(p); 
                //System.out.println(p.nextPairing);
            } 
        } 
  
        return notPairedPlayers; 
    } 
  
    // pair players manually from database 
    public Player GetManuallyPairedPlayer(Player player)  
    {  
    	if(player.nextPairing.isEmpty())     
            return null; 
        if (!player.nextPairing.isEmpty()) 
        { 
            return GetPlayerById(player.nextPairing); 
        } 
        return null; 
    } 
  
  public int getChanceWin(Pair<Player, Player> pair, Player p2) {
	  int diff = pair.second.currentRating - p2.currentRating; 
      double ExpectationPower = diff/400;
      double ExpectationPowerTo = Math.pow(10, ExpectationPower);
      int WinningChange = (int) (ExpectationPowerTo *100);
      return WinningChange;
	
}
  
} 