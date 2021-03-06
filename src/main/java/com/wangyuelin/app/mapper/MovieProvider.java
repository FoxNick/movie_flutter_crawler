package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Movie;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class MovieProvider {

    public String insert(@Param("movie") Movie movie) {
        return new SQL(){
            {
                INSERT_INTO("movie");
                INTO_COLUMNS("name", "actors", "quality", "other_name", "directors", "locations", "language", "year", "duration", "intro", "douban_rank", "covers", "froms");
                INTO_VALUES("#{movie.name}", "#{movie.actorsStr}", "#{movie.quality}", "#{movie.otherNamesStr}", "#{movie.directorsStr}",
                        "#{movie.locationsStr}", "#{movie.language}", "#{movie.year}", "#{movie.duration}", "#{movie.intro}", "#{movie.doubanRank}",
                        "#{movie.coversStr}", "#{movie.fromsStr}");

            }
        }.toString();

    }

    public String getById(@Param("id") long id) {
        return new SQL(){
            {
                SELECT("*");
                FROM("movie");
                WHERE("id = #{id}");
            }
        }.toString();

    }
}
