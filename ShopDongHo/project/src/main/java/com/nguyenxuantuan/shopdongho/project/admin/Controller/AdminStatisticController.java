package com.nguyenxuantuan.shopdongho.project.admin.Controller;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenxuantuan.shopdongho.project.dao.StatisticDao;
import com.nguyenxuantuan.shopdongho.project.model.OrderDetailDTO;
import com.nguyenxuantuan.shopdongho.project.model.StatisticDTO;
import com.nguyenxuantuan.shopdongho.project.service.StatisticService;

@Controller
@RequestMapping("/admin")
public class AdminStatisticController {
	@Autowired
	private StatisticService statisticService;

	@GetMapping("/statistic")
	public String getStatistic() {

		return "admin/statistic";
	}

	@GetMapping("/statistic-detail")
	public String getStatisticByMonth(HttpServletRequest request, Model model,
			@RequestParam(name = "day_search", required = false, defaultValue = "") String date,
			@RequestParam(name = "type_statistic", required = false, defaultValue = "") String type) {
		String[] dates = date.split("\\-");
		String txtDay = dates[2];
		String txtMonth = dates[1];
		String txtYear = dates[0];
		
		int day = Integer.parseInt(txtDay);
		int month = Integer.parseInt(txtMonth);
		int year = Integer.parseInt(txtYear);

		if (type.equals("Year")) {
			String search = txtYear;
			model.addAttribute("dates", search);
			StatisticDTO staDTO = statisticService.getStatisticByYear(year);
			List<OrderDetailDTO> odDTOs = statisticService.getOrderDetailByYear(year);
			request.setAttribute("statistic", staDTO);
			request.setAttribute("orderDetail", odDTOs);
		} else if (type.equalsIgnoreCase("Month")) {
			String search = txtMonth +"/"+txtYear;
			model.addAttribute("dates", search);
			StatisticDTO staDTO = statisticService.getStatisticByMonth(month, year);
			List<OrderDetailDTO> odDTOs = statisticService.getOrderDetailByMonth(month, year);
			request.setAttribute("statistic", staDTO);
			request.setAttribute("orderDetail", odDTOs);
		} else if (type.equals("Day")) {
			String search = txtDay +"/" +txtMonth +"/"+txtYear;
			model.addAttribute("dates", search);
			StatisticDTO staDTO = statisticService.getStatisticByDay(day, month, year);
			List<OrderDetailDTO> odDTOs = statisticService.getOrderDetailByDay(day, month, year);
			request.setAttribute("statistic", staDTO);
			request.setAttribute("orderDetail", odDTOs);
		}

		return "admin/statistic";
	}
}
