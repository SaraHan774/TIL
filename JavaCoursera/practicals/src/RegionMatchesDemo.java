public class RegionMatchesDemo {

    /*
    * boolean regionMatches(int toffset, String other, int ooffset, int len)
    * Tests whether the specified region of this string matches the specified region of the string argument
    * region is of length len and begins at the index toffset for this string and ooffset for the other string
    * */
    public static void main(String[] args) {
        String searchMe = "Green Eggs and Ham";
        //Eggs 의 길이만큼 인덱스 1 씩 이동하며 Eggs 가 스트링 안에 들어있는지 찾는다.
        String findMe = "Eggs";

        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();

        boolean foundIt = false;

        for(int i =0; i <= (searchMeLength - findMeLength); i++){
            System.out.println("i : " + i);
            if(searchMe.regionMatches(i, findMe, 0, findMeLength)){
                foundIt = true;
                System.out.println(searchMe.substring(i , i+findMeLength));
                break;
            }
        }
        if(!foundIt){
            System.out.println("No match found.");
        }
    }
}
