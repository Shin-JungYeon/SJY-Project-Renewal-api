package sjy.jaengsplay.api.framework.util;

public enum PointUtil {

    /**
     * 1일 최초 로그인
     */
    LOGIN("login", 500L),

    /**
     * 1일 리뷰 1회 작성
     */
    REVIEW("review", 100L),

    /**
     * 1일 댓글 5회 작성
     */
    COMMENT("comment", 50L)

    ;

    private String value;
    private Long amt;

    PointUtil(String value, Long amt) {
        this.value = value;
        this.amt = amt;
    }

    public String getValue() {
        return value;
    }

    public Long getAmt() {
        return amt;
    }
}
