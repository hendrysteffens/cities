package com.senior.erp.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.senior.erp.domain.UF;
import com.senior.erp.repository.UFRepository;

@Repository
public class UFRepositoryImpl implements UFRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UF findWithMoreCities() {
		return jdbcTemplate.queryForObject(FIND_UF_WITH_MORE_CITIES_QUERY, new UFRowMapper());
	}
	
	@Override
	public UF findWithLessCities() {
		return jdbcTemplate.queryForObject(FIND_UF_WITH_LESS_CITIES_QUERY, new UFRowMapper());
	}
	
	@Override
	public List<UF> findAllUF() {
		return jdbcTemplate.query(FIND_ALL_UF_QUERY, new UFRowMapper());
	}
	
	private static final class UFRowMapper implements RowMapper<UF> {

        @Override
        public UF mapRow(ResultSet rs, int rowNum) throws SQLException {
            UF uf = new UF();
            uf.setName(rs.getString("name"));
            uf.setTotalCities(rs.getInt("totalCities"));
            return uf;
        }

    }
	
	public final String FIND_UF_WITH_MORE_CITIES_QUERY = "SELECT uf as name, COUNT(*) as totalCities FROM " + // 
                                        "City GROUP BY UF ORDER BY totalCities DESC FETCH FIRST 1 ROW ONLY"; //

	public final String FIND_UF_WITH_LESS_CITIES_QUERY = "SELECT uf as name, COUNT(*) as totalCities FROM " + // 
                                         "City GROUP BY UF ORDER BY totalCities ASC FETCH FIRST 1 ROW ONLY"; //
	
	private static final String FIND_ALL_UF_QUERY = "SELECT uf as name, COUNT(*) as totalCities FROM City GROUP BY UF";

}
