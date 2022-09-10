package org.example.score.model;

import java.math.BigDecimal;

public class UserScore {
    private Integer userId;
    private BigDecimal score;

    public UserScore(Integer userId, BigDecimal score) {
        this.userId = userId;
        this.score = score;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserScore{" +
                "userId=" + userId +
                ", score=" + score +
                '}';
    }
}
