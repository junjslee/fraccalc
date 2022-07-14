import java.util.*; 
public class FracCalc {
    public static void main(String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        String inputLine = inputScanner.nextLine();
        System.out.println(produceAnswer(inputLine));
    }
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"       
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static int gcf(int p, int q) {
        while (q != 0) {
            int haha = q;
            q = p % q;
            p = haha;
        }
        return p;
    }

    public static String produceAnswer(String input)
    { 
        // check point 1
        int x = input.indexOf(" ");
        String firstTerm = input.substring(0,x);
        int y = input.lastIndexOf(" ");
        String secondTerm = input.substring(y+1);
        String mid = input.substring(x,y);
        System.out.println(mid);
        //check point 2
        int w1, z1, w2, z2;
        int p, q;
        String wholeNumber1; String denominator1; String numerator1; 
        String wholeNumber2; String denominator2; String numerator2;
        w1 = firstTerm.indexOf("_"); z1 = firstTerm.indexOf("/");
        if(firstTerm.contains("_")){
            wholeNumber1 = firstTerm.substring(0,w1);
            if(firstTerm.contains("/")){
                numerator1 = firstTerm.substring(w1+1,z1);
                denominator1 = firstTerm.substring(z1+1);
            }
            else {
                numerator1 = "0";
                denominator1 = "1";
            }
        }
        else {
            if(firstTerm.contains("/")){
                wholeNumber1 = "0";
                numerator1 = firstTerm.substring(0,z1);
                denominator1 = firstTerm.substring(z1+1);
            }
            else {
                wholeNumber1 = firstTerm;
                numerator1 = "0";
                denominator1 = "1";
            }
        }
        z2 = secondTerm.indexOf("/"); w2 = secondTerm.indexOf("_");
        if(secondTerm.contains("_")){
            wholeNumber2 = secondTerm.substring(0,w2);
            if(secondTerm.contains("/")){
                numerator2 = secondTerm.substring(w2+1,z2);
                denominator2 = secondTerm.substring(z2+1);
            }
            else {
                numerator2 = "0";
                denominator2 = "1";
            }
        }
        else {
            if(secondTerm.contains("/")){
                wholeNumber2 = "0";
                numerator2 = secondTerm.substring(0,z2);
                denominator2 = secondTerm.substring(z2+1);
            }
            else {
                wholeNumber2 = secondTerm;
                numerator2 = "0";
                denominator2 = "1";
            }
        }
        //check point 3
        int wNumber2 = Integer.parseInt(wholeNumber2);
        int nNumber2 = java.lang.Integer.parseInt(numerator2);
        int dNumber2 = java.lang.Integer.parseInt(denominator2);
        int wNumber1 = Integer.parseInt(wholeNumber1);
        int nNumber1 = java.lang.Integer.parseInt(numerator1);
        int dNumber1 = java.lang.Integer.parseInt(denominator1);
        int nTotal; int dTotal; int wTotal; 
        int ai = firstTerm.indexOf("-");
        int ya = secondTerm.indexOf("-");
        if(input.contains("+")){
            if(dNumber1 == dNumber2){
                if(dNumber1 == 1){
                    wNumber1= wNumber1 + wNumber2;
                    return "" + wNumber1;
                }
                else {
                    wNumber1 = wNumber1 * dNumber1;
                    wNumber2 = wNumber2 * dNumber2;
                    if(firstTerm.contains("-")){
                        wNumber1 = wNumber1 - nNumber1;
                    }
                    else {
                        wNumber1 = wNumber1 + nNumber1;
                    }
                    if(secondTerm.contains("-")){
                        wNumber2 = wNumber2 - nNumber2;
                    }
                    else {
                        wNumber2 = wNumber2 + nNumber2;
                    }

                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dNumber1;
                    nTotal = Math.abs(nTotal % dNumber1); 
                    int gcf = gcf(nTotal, dNumber1);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dNumber1 = dNumber1 / Math.abs(gcf);
                    }

                    if(wTotal == 0){
                        return "" + nTotal + "/" + dNumber1;
                    }
                    else{
                        if(nTotal == 0){
                            return "" + wTotal;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dNumber1;   
                        }
                    }
                }
            }
            else{
                if(dNumber1 == 1){
                    wNumber1 = wNumber1 * dNumber2;
                    wNumber2 = wNumber2 * dNumber2;
                    if(secondTerm.contains("-")){
                        wNumber2 = wNumber2 - nNumber2;
                    }
                    else {
                        wNumber2 = wNumber2 + nNumber2;
                    }
                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dNumber2;
                    nTotal = nTotal % dNumber2;
                    int gcf = gcf(nTotal, dNumber2);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dNumber2 = dNumber2 / Math.abs(gcf);
                    }
                    if(wTotal == 0){
                        if(nTotal == 0){
                            return "" + 0;
                        }
                        else {
                            return "" + nTotal + "/" + dNumber2;
                        }
                    }
                    else{
                        if(nTotal == 0){
                            return "" + wTotal;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dNumber2;
                        }
                    }
                }
                else if(dNumber2 == 1){
                    wNumber1 = wNumber1 * dNumber2;                    
                    wNumber2 = wNumber2 * dNumber1;
                    if(firstTerm.contains("-")){
                        wNumber1 = wNumber1 - nNumber1;
                    }
                    else {
                        wNumber1 = wNumber1 + nNumber1;
                    }
                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dNumber1;
                    nTotal = nTotal % dNumber1;
                    int gcf = gcf(nTotal, dNumber1);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dNumber1 = dNumber1 / Math.abs(gcf);
                    }
                    if(wTotal == 0){
                        if(nTotal == 0){
                            return "" + 0;
                        }
                        else {
                            return "" + nTotal + "/" + dNumber1;
                        }
                    }
                    else{
                        if(nTotal == 0){
                            return "" + 0;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dNumber1;
                        }
                    }
                }
                else{
                    dTotal = dNumber1 * dNumber2;
                    wNumber1 = dNumber1 * wNumber1;
                    wNumber2 = dNumber2 * wNumber2;
                    if(firstTerm.contains("-")){
                        wNumber1 = wNumber1 - Math.abs(nNumber1);
                    }
                    else {
                        wNumber1 = wNumber1 + Math.abs(nNumber1);
                    }
                    if(secondTerm.contains("-")){
                        wNumber2 = wNumber2 - Math.abs(nNumber2);
                    }
                    else {
                        wNumber2 = wNumber2 + Math.abs(nNumber2);
                    }
                    wNumber1 = wNumber1 * dNumber2;
                    wNumber2 = wNumber2 * dNumber1;
                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dTotal;
                    nTotal = nTotal % dTotal;
                    int gcf = gcf(nTotal, dTotal);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dTotal = dTotal / Math.abs(gcf);
                    }
                    if(wTotal == 0){
                        if(nTotal == 0) {
                            return "" + 0;
                        }
                        else {  

                            return "" + nTotal + "/" + dTotal;
                        }
                    }
                    else{
                        nTotal = Math.abs(nTotal);
                        if(nTotal == 0){
                            return "" + wTotal;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dTotal;   
                        }
                    }    
                }
            }
        }

        if(mid.contains("-")){
            if(dNumber1 == dNumber2){
                if(dNumber1 == 1){
                    if(secondTerm.contains("-")){
                        wNumber1 = wNumber1 + Math.abs(wNumber2);
                    }
                    else {
                        wNumber1 = wNumber1 - Math.abs(wNumber2);
                    }
                    wTotal = wNumber1;
                    return "" + wTotal;
                }
                else {
                    wNumber1 = wNumber1 * dNumber1;
                    wNumber2 = wNumber2 * dNumber2;
                    if(firstTerm.contains("-")){
                        wNumber1 = wNumber1 - nNumber1;
                    }
                    else {
                        wNumber1 = wNumber1 + nNumber1;
                    }
                    if(secondTerm.contains("-")){
                        wNumber2 = wNumber2 - nNumber2;
                    }
                    else {
                        wNumber2 = wNumber2 + nNumber2;
                    }

                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dNumber1;
                    nTotal = nTotal % dNumber1; 
                    int gcf = gcf(nTotal, dNumber1);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dNumber1 = dNumber1 / Math.abs(gcf);
                    }
                    if(wTotal == 0){
                        if(nTotal == 0) {
                            return "" + 0;
                        }
                        else {

                            return "" + nTotal + "/" + dNumber1;
                        }
                    }
                    else{
                        nTotal = Math.abs(nTotal);
                        if(nTotal == 0){
                            return "" + wTotal;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dNumber1;   
                        }
                    }
                }
            }
            else{
                if(dNumber1 == 1){
                    wNumber1 = wNumber1 * dNumber2;
                    wNumber2 = wNumber2 * dNumber2;
                    if(secondTerm.contains("-")){
                        wNumber2 = wNumber2 - nNumber2;
                    }
                    else {
                        wNumber2 = wNumber2 + nNumber2;
                    }
                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dNumber2;
                    nTotal = nTotal % dNumber2;
                    int gcf = gcf(nTotal, dNumber2);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dNumber2 = dNumber2 / Math.abs(gcf);
                    }
                    if(wTotal == 0){
                        if(nTotal == 0){
                            return "" + 0;
                        }
                        else {
                            return "" + nTotal + "/" + dNumber2;
                        }
                    }
                    else{
                        nTotal = Math.abs(nTotal);
                        if(nTotal == 0){
                            return "" + wTotal;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dNumber2;
                        }
                    }
                }
                else if(dNumber2 == 1){
                    wNumber1 = wNumber1 * dNumber1;
                    wNumber2 = wNumber2 * dNumber1;
                    if(firstTerm.contains("-")){
                        wNumber1 = wNumber1 - nNumber1;
                    }
                    else {
                        wNumber1 = wNumber1 + nNumber1;
                    }
                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dNumber1;
                    nTotal = nTotal % dNumber1;
                    int gcf = gcf(nTotal, dNumber1);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dNumber1 = dNumber1 / Math.abs(gcf);
                    }
                    if(wTotal == 0){
                        if(nTotal == 0){
                            return "" + 0;
                        }
                        else {
                            return "" + nTotal + "/" + dNumber1;
                        }
                    }
                    else{
                        nTotal = Math.abs(nTotal);
                        if(nTotal == 0){
                            return "" + wTotal;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dNumber1;
                        }
                    }
                }
                else{
                    dTotal = dNumber1 * dNumber2;
                    wNumber1 = dNumber1 * wNumber1;
                    wNumber2 = dNumber2 * wNumber2;
                    if(firstTerm.contains("-")){
                        wNumber1 = wNumber1 - nNumber1;
                    }
                    else {
                        wNumber1 = wNumber1 + nNumber1;
                    }
                    if(secondTerm.contains("-")){
                        wNumber2 = wNumber2 - nNumber2;
                    }
                    else {
                        wNumber2 = wNumber2 + nNumber2;
                    }
                    wNumber1 = wNumber1 * dNumber2;
                    wNumber2 = wNumber2 * dNumber1;
                    if(secondTerm.contains("-")) {
                        nTotal = wNumber1 + Math.abs(wNumber2);
                    }
                    else {
                        nTotal = wNumber1 - Math.abs(wNumber2);
                    }
                    wTotal = nTotal / dTotal;
                    nTotal = nTotal % dTotal;
                    int gcf = gcf(nTotal, dTotal);
                    if (gcf != 1) {
                        nTotal = nTotal / Math.abs(gcf);
                        dTotal = dTotal / Math.abs(gcf);
                    }
                    if(wTotal == 0){
                        if(nTotal == 0){
                            return "" + 0;
                        }
                        else {
                            return "" + nTotal + "/" + dTotal;
                        }
                    }
                    else{
                        nTotal = Math.abs(nTotal);
                        if(nTotal == 0){
                            return "" + wTotal;
                        }
                        else {
                            return "" + wTotal + "_" + nTotal + "/" + dTotal;
                        }
                    }
                }
            }
        }

        if(mid.contains("/")){
            wNumber1 = wNumber1 * dNumber1;
            wNumber2 = wNumber2 * dNumber2;
            if(firstTerm.contains("-")){
                wNumber1 = wNumber1 - nNumber1;
            }
            else {
                wNumber1 = wNumber1 + nNumber1;
            }
            if(secondTerm.contains("-")){
                wNumber2 = wNumber2 - nNumber2;
            }
            else {
                wNumber2 = wNumber2 + nNumber2;
            }
            // multiplication starts here
            if((firstTerm.contains("-") && secondTerm.contains("-")) || (ya == -1 && ai == -1)) {
                if(dNumber1 == dNumber2) {
                    if(dNumber1 == 1) {
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
                else {
                    if(dNumber1 == 1){ 
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                    else if(dNumber2 == 1){
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
            }
            else {
                if(dNumber1 == dNumber2) {
                    if(dNumber1 == 1) {
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + (nTotal * -1) + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal * -1;
                            }
                            else {
                                return "" + wTotal * -1 + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal * -1 + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal * -1;
                            }
                            else {
                                return "" + wTotal * -1 + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
                else {
                    if(dNumber1 == 1){ 
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal * -1 + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal * -1;
                            }
                            else {
                                return "" + wTotal * -1 + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                    else if(dNumber2 == 1){
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal * -1 + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal * -1;
                            }
                            else {
                                return "" + wTotal * -1 + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber2;
                        wNumber2 = wNumber2 * dNumber1;
                        nTotal = Math.abs(wNumber1); dTotal = Math.abs(wNumber2);
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal * -1 + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal * -1;
                            }
                            else {
                                return "" + wTotal * -1 + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
            }
        }

        if(input.contains("*")) {
            if((firstTerm.contains("-") && secondTerm.contains("-")) || (ya == -1 && ai == -1)) {
                if(dNumber1 == dNumber2) {
                    if(dNumber1 == 1) {
                        wNumber1 = wNumber1 * wNumber2;
                        wTotal = Math.abs(wNumber1);
                        return "" + wTotal;
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber1; 
                        wNumber2 = wNumber2 * dNumber2;
                        if(firstTerm.contains("-")){
                            wNumber1 = wNumber1 - Math.abs(nNumber1);
                        }
                        else {
                            wNumber1 = wNumber1 + Math.abs(nNumber1);
                        }
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - Math.abs(nNumber2);
                        }
                        else {
                            wNumber2 = wNumber2 + Math.abs(nNumber2);
                        }
                        dTotal = dNumber1 * dNumber2;
                        nTotal = wNumber1 * wNumber2;
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
                else {
                    if(dNumber1 == 1){ 
                        wNumber2 = wNumber2 * dNumber2;
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - Math.abs(nNumber2);
                        }
                        else {
                            wNumber2 = wNumber2 + Math.abs(nNumber2);
                        }
                        nTotal = wNumber1 * wNumber2;
                        wTotal = nTotal / dNumber2;
                        nTotal = nTotal % dNumber2;
                        int gcf = gcf(nTotal, dNumber2);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dNumber2 = dNumber2 / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dNumber2;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dNumber2;
                            }
                        }
                    }
                    else if(dNumber2 == 1){
                        wNumber1 = wNumber1 * dNumber1;
                        if(firstTerm.contains("-")){
                            wNumber1 = wNumber1 - Math.abs(nNumber1);
                        }
                        else {
                            wNumber1 = wNumber1 + Math.abs(nNumber1);
                        }
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - Math.abs(nNumber2);
                        }
                        else {
                            wNumber2 = wNumber2 + Math.abs(nNumber2);
                        }
                        nTotal = wNumber1 * wNumber2;
                        wTotal = Math.abs(nTotal / dNumber1);
                        nTotal = Math.abs(nTotal % dNumber1);
                        int gcf = gcf(nTotal, dNumber1);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dNumber1 = dNumber1 / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dNumber1;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dNumber1;
                            }
                        }
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber1; 
                        wNumber2 = wNumber2 * dNumber2;
                        if(firstTerm.contains("-")){
                            wNumber1 = wNumber1 - Math.abs(nNumber1);
                        }
                        else {
                            wNumber1 = wNumber1 + Math.abs(nNumber1);
                        }
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - nNumber2;
                        }
                        else {
                            wNumber2 = wNumber2 + nNumber2;
                        }
                        dTotal = dNumber1 * dNumber2;
                        nTotal = wNumber1 * wNumber2;
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
            }
            else {
                if(dNumber1 == dNumber2) {
                    if(dNumber1 == 1) {
                        wNumber1 = wNumber1 * wNumber2;
                        wTotal = wNumber1;
                        return "" + wTotal;
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber1; 
                        wNumber2 = wNumber2 * dNumber2;
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - Math.abs(nNumber2);
                        }
                        else {
                            wNumber2 = wNumber2 + Math.abs(nNumber2);
                        }
                        dTotal = dNumber1 * dNumber2;
                        nTotal = wNumber1 * wNumber2;
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
                else {
                    if(dNumber1 == 1){ 
                        wNumber2 = wNumber2 * dNumber2;
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - Math.abs(nNumber2);
                        }
                        else {
                            wNumber2 = wNumber2 + Math.abs(nNumber2);
                        }
                        nTotal = wNumber1 * wNumber2;
                        wTotal = nTotal / dNumber2;
                        nTotal = nTotal % dNumber2;
                        int gcf = gcf(nTotal, dNumber2);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dNumber2 = dNumber2 / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dNumber2;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dNumber2;
                            }
                        }
                    }
                    else if(dNumber2 == 1){
                        dTotal = dNumber1 * dNumber2;
                        wNumber1 = wNumber1 * dNumber1;
                        if(firstTerm.contains("-")){
                            wNumber1 = wNumber1 - Math.abs(nNumber1);
                        }
                        else {
                            wNumber1 = wNumber1 + Math.abs(nNumber1);
                        }
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - Math.abs(nNumber2);
                        }
                        else {
                            wNumber2 = wNumber2 + Math.abs(nNumber2);
                        }
                        nTotal = wNumber1 * wNumber2;
                        wTotal = nTotal / dNumber1;
                        nTotal = nTotal % dNumber1;
                        int gcf = gcf(nTotal, dNumber1);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dNumber1 = dNumber1 / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dNumber1;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dNumber1;
                            }
                        }
                    }
                    else{
                        wNumber1 = wNumber1 * dNumber1; 
                        wNumber2 = wNumber2 * dNumber2;
                        if(firstTerm.contains("-")){
                            wNumber1 = wNumber1 - Math.abs(nNumber1);
                        }
                        else {
                            wNumber1 = wNumber1 + Math.abs(nNumber1);
                        }
                        if(secondTerm.contains("-")){
                            wNumber2 = wNumber2 - Math.abs(nNumber2);
                        }
                        else {
                            wNumber2 = wNumber2 + Math.abs(nNumber2);
                        }
                        dTotal = dNumber1 * dNumber2;
                        nTotal = wNumber1 * wNumber2;
                        wTotal = nTotal / dTotal;
                        nTotal = nTotal % dTotal;
                        int gcf = gcf(nTotal, dTotal);
                        if (gcf != 1) {
                            nTotal = nTotal / Math.abs(gcf);
                            dTotal = dTotal / Math.abs(gcf);
                        }
                        if(wTotal == 0){
                            if(nTotal == 0){
                                return "" + 0;
                            }
                            else {
                                return "" + nTotal + "/" + dTotal;
                            }
                        }
                        else{
                            nTotal = Math.abs(nTotal);
                            if(nTotal == 0){
                                return "" + wTotal;
                            }
                            else {
                                return "" + wTotal + "_" + nTotal + "/" + dTotal;
                            }
                        }
                    }
                }
            }
        }
        else {
            return "" + 0;
        }
    }
    // how does simplication work?
}
// TODO: Fill in the space below with any helper methods that you think you will need
// Integer parseInt: String to Int
