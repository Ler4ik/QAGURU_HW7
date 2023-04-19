package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year){
        $("select.react-datepicker__month-select").selectOption(month);
        $("select.react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day
                    + ":not(.react-datepicker__day--outside-month)").click();
        }
    }
