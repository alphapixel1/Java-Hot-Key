package edu.uc.javahotkey.dao;

import edu.uc.javahotkey.dto.KeyMap;
import edu.uc.javahotkey.dto.Project;
import org.aspectj.weaver.ast.Call;
import org.springframework.data.jpa.repository.Query;
import retrofit2.http.GET;

import java.util.List;

public interface IProjectRetrofitDAO {

    //TODO update method with actual JSON endpoint

    /*
    @GET("/")
    Call<List<Project>> getProjects(@Query("Name") String projectName);
    */

}
