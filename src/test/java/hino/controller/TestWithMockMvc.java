package hino.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
public class TestWithMockMvc {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void test() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk());
  }
}
