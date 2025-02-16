package kit;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579
public class Hash5_L3_베스트앨범 {

    public static void main(String[] args) {
        /**
         * 입출력 예
         * genres	                                        plays	                    return
         * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
         */

        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"}; 
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(getMusicNos_1(genres,plays)));

    }




    private static int[] getMusicNos_1(String[] genres, int[] plays) {
        class Music implements Comparable<Music> {
            int id;     // 고유번호
            int play;   // 재생횟수

            public Music(int id, int play){
                this.id = id;
                this.play = play;
            }


            @Override
            public int compareTo(Music otherMusic){
                // 재생횟수 같을 경우, 고유번호 기준 오름차순 정렬하기 위함
                if(this.play == otherMusic.play){
                    return this.id - otherMusic.id;
                }

                // 재생횟수 다를 경우, 재생횟수 기준 오름차순 정렬하기 위함
                return otherMusic.play - this.play;
            }
        }


        int n = genres.length;
        // 1. 장르별 재생횟수 합산 (속한 노래가 많이 재생된 장르를 먼저 수록) ---> 장르 길이만큼

        Map<String, Integer> totalPlayByGenres = new HashMap<>(); // key 장르, value 재생횟수
        for(int i = 0; i < n; i++) {
            totalPlayByGenres.put(genres[i], totalPlayByGenres.getOrDefault(genres[i],0) + plays[i]);
        }

        // 2. Map<장르명, 장르별 노래목록 List> 생성 (장르 내에서 많이 재생된 노래를 먼저 수록)
        Map<String, List<Music>> musicsByGenre = new HashMap<>();
        for(int i = 0; i < n; i++) {
            musicsByGenre.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(i, plays[i]));
        }

        // 3. 장르별 노래목록 정렬 (장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록)
        for(List<Music> musics : musicsByGenre.values()) {
            Collections.sort(musics); // Music compareTo로 정렬 ----------->
        }

        // 4. 베스트 앨범 구성
        List<Integer> bestAlbums = new ArrayList<>();
        List<String> sortedGenres = new ArrayList<>(totalPlayByGenres.keySet()); // 일단 장르명으로 list 생성

        // 4-1. 전체 장르 정렬 : [1] 장르별 재생횟수 합산 값 큰 순서(내림차순)
        Collections.sort(sortedGenres, (a,b) -> totalPlayByGenres.get(b) - totalPlayByGenres.get(a));

        // 4-2. 정해진 순서의 장르 내에서 2곡 씩 고유번호 정렬
        for(String genre : sortedGenres){
            List<Music> musics = musicsByGenre.get(genre);


            // ----------------- 2곡씩만
            int cnt = 0;
            for (Music music : musics){
                bestAlbums.add(music.id);
                cnt++;
                if(cnt == 2) break;
            }

            // ----------------- 2곡씩만, fori로하면 안됨? ==> 이렇게 하면 장르가 한개씩 있는 경우가 안된다!
            // for(int i=0; i <= 1; i++) {
            //    bestAlbums.add(musics.get(i).id);
            // }
        }

        // 5. 최종결과 고유번호들 리턴
        return bestAlbums.stream()
                .mapToInt(i -> i)
                .toArray();
    }

            /*
           고유번호    장르         재생횟수
           0         classic     500
           1         pop         600
           2         classic     150
           3         classic     800
           4         pop         2500
           ------------------------------

           ------------------------------

           1. 총 재생횟수 최대값인 장르 우선순위
           2. 장르 내 재생횟수 최대값인 곡(인덱스번호가 고유번호) 우선순위
           3. 장르 내 재생횟수 동일값인 경우, 인덱스 작은 순서가 우선수위
           ## 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시 --> top2까지만 고르고 다음 장르 골라야됨
        */

    // genres 길이만큼 배열 생성, 배열 요소는 Map<고유번호, <String, Integer>> ?

    // 1. 총 재생횟수 최대값인 장르 우선순위 : Set 생성해서 재생횟수 총량 정함 --> 장르우선순위 지정 총 리턴배열 길이 설정 (set.size*2)

    // 2. 각 장르 별 배열 생성, 재생횟수 동일값 있는지 확인
    // 2-1. 동일값 있으면 인덱스 작은걸로 지정
    // 2-2. 동일값 없으면 재생횟수 큰순서 지정 --> 장르 내 곡 우선순위 선정, 인덱스값으로 리턴값 세팅


    // 3. set의 우선순위를 순서로 / 2개씩 곡 우선수위 값넣기
}
