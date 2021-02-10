//
//import java.util.Scanner;
//
//public class Test {
//
//    static int spareBonusPoint = 5;
//
//    static String spareSymbol = "/";
//
//    static int strikeBonusPoint = 10;
//
//    static String strikeSymbol = "X";
//
//    static int totalSet = 10;
//
//    static  int totalNoOfPins = 10;
//
//    static  int noOfChancesInEachSet = 2;
//
//    static  int noOfChancesInFinalSet = 3;
//
//
//    public static void main(String[] args){
//        Scanner sc= new Scanner(System.in);
//        int noOfPlayers = sc.nextInt();
//        Player[] players = new Player[noOfPlayers];
//        for(int i=0;i<noOfPlayers;i++){
//            players[i] = new Player();
//        }
//        for(int set=1;set<=totalSet;set++){
//            for(int playerNumber=0;playerNumber<noOfPlayers;playerNumber++){
//                int ballCount = 1;
//                do{
//                    String input = sc.next();
//                    players[playerNumber].ballResults.add(input);
//                    players[playerNumber].totalBalls++;
//                    if(Character.isDigit(input.charAt(0))){
//                        players[playerNumber].score += Integer.parseInt(input);
//                    }else{
//                        if(input.equals(spareSymbol)){
//                            String previousBall = players[playerNumber].ballResults.get(players[playerNumber].totalBalls-2);
//                            players[playerNumber].score += ((totalNoOfPins - Integer.parseInt(previousBall)) + spareBonusPoint);
//                        }
//                        else if(input.equals(strikeSymbol)){
//                            players[playerNumber].score += (totalNoOfPins+strikeBonusPoint);
//                        }
//                        else{
//                            System.out.println("Invalid input");
//                            System.exit(0);
//                        }
//                        if(set == totalSet && ballCount!=noOfChancesInFinalSet){
//                            ballCount++;
//                            printScoreBoard(players,noOfPlayers);
//                            continue;
//                        }
//                    }
//
//                    if(ballCount >= noOfChancesInEachSet || input.equals(strikeSymbol)){
//                        printScoreBoard(players,noOfPlayers);
//                        break;
//                    }
//                    printScoreBoard(players,noOfPlayers);
//                    ballCount++;
//                }while (true);
//            }
//
//        }
//        int leaderBoardScore =0, leaderBoardPlayerIndex = -1;
//        for(int playerNumber=0;playerNumber<noOfPlayers;playerNumber++){
//            if(players[playerNumber].score>leaderBoardScore){
//                leaderBoardScore = players[playerNumber].score;
//                leaderBoardPlayerIndex =playerNumber;
//            }
//        }
//        System.out.println("P"+(leaderBoardPlayerIndex+1)+" is the winner with "+ leaderBoardScore+" score");
//    }
//
//    public static void printScoreBoard(Player[] players,int noOfPlayers){
//        System.out.println("Scoreboard:");
//        for(int i=0;i<noOfPlayers;i++){
//            System.out.println("P"+(i+1)+":"+
//                    players[i].ballResults.toString()
//                            .replace(",", "")
//                            .replace("[", "")
//                            .replace("]", "").trim() + " -> " + players[i].score);
//        }
//    }
//}