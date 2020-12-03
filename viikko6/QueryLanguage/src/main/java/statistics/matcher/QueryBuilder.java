/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author matibrax
 */
public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public QueryBuilder(Matcher mathcher) {
        this.matcher = mathcher;
    }
    
     public Matcher build() {
        return this.matcher;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        Matcher m = new Or(m1, m2);
        QueryBuilder q = new QueryBuilder(m);
        return q;
    }

    public QueryBuilder playsIn(String team) {
        Matcher m = new And(matcher, new PlaysIn(team));
        QueryBuilder q = new QueryBuilder(m);
        return q;
    }

    public QueryBuilder hasAtLeast(int i, String goals) {
        Matcher m = new And(matcher, new HasAtLeast(i, goals));
        QueryBuilder q = new QueryBuilder(m);
        return q;
    }
    
    public QueryBuilder hasFewerThan(int i, String goals) {
        Matcher m = new And(matcher, new HasFewerThan(i, goals));
        QueryBuilder q = new QueryBuilder(m);
        return q;
    }


    
}
