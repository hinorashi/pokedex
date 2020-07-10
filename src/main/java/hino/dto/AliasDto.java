package hino.dto;

import static hino.common.Constant.ALIAS_MAX_LENGTH;
import static hino.common.Constant.ALIAS_MIN_LENGTH;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliasDto {

  @NotEmpty(message = "You should name your buddy!")
  @Length(min = ALIAS_MIN_LENGTH, max = ALIAS_MAX_LENGTH, message = "Are you sure with that lengthy name?")
  private String alias;
}
