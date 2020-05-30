package com.jeevan.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jeevan.main.AtmSpringBootApplication;
import com.jeevan.main.model.Customer;
import com.jeevan.main.service.CustService;

@Controller
public class CustController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustController.class);

	@Autowired
	CustService service;

	@RequestMapping("/CreateAccount")
	public ModelAndView addCustomer(ModelAndView mv) {
		LOGGER.info("In addCustomer Controller");
		mv.addObject("customer", new Customer());
		mv.setViewName("RegisterCustomer");
		return mv;
	}

	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public String registerSuccess(@ModelAttribute("customer") Customer customer, Model model) {

		LOGGER.info("In registerSuccess Controller");

		System.out.println("I am in registerSuccess controller");
		service.addCustomer(customer);
		model.addAttribute("customer", customer);
		return "DisplayAcDetails";
	}

	@RequestMapping("/customerList")
	public String customerDetails(Model model) {
		LOGGER.info("In customerDetails Controller");

		List<Customer> cl = new ArrayList<Customer>();
		cl = service.getAllCustomers();
		model.addAttribute("list", cl);
		return "CustomerDetails";
	}

	@RequestMapping("/BalanceEnquiry")
	public String balanceByid(HttpServletRequest req, Model m) {
		LOGGER.info("In balanceByid Controller");

		Integer id = Integer.parseInt(req.getParameter("acno"));

		Customer customer = service.getBalanceByid(id);

		System.out.println("Again in balanceByid   :" + customer.getBalance());
		m.addAttribute("customer", customer);

		return "ShowBalance";
	}

	@RequestMapping("/fundTranser")
	public String fundTranser(HttpServletRequest req, Model m) {

		LOGGER.info("In fundTranser Controller");

		Integer acno1 = Integer.parseInt(req.getParameter("acno1"));
		Integer pin = Integer.parseInt(req.getParameter("pin"));
		Integer ammount = Integer.parseInt(req.getParameter("amount"));
		Integer acno2 = Integer.parseInt(req.getParameter("acno2"));

		if (service.verifyAccountByPin(pin, acno1)) {
			Integer afterAmmount = service.withdraw(acno1, ammount);
			if (afterAmmount == 0)
				return "errorBal";
			else {
				m.addAttribute("balance", afterAmmount);
				service.deposit(acno2, ammount);
				return "DisplayBal";
			}

		} else {
			return "errorpassword";
		}

	}

	@RequestMapping("/controllerWithdraw")
	public String withdraw(HttpServletRequest req, Model m) {
		LOGGER.info("In withdraw Controller");

		Integer accNum = Integer.parseInt(req.getParameter("acno"));
		Integer pin = Integer.parseInt(req.getParameter("pin"));
		Integer ammount = Integer.parseInt(req.getParameter("ammount"));

		if (service.verifyAccountByPin(pin, accNum)) {
			Integer afterAmmount = service.withdraw(accNum, ammount);
			if (afterAmmount == 0)
				return "errorBal";
			else {
				m.addAttribute("balance", afterAmmount);
			}
		}
		return "DisplayBal";
	}

	@RequestMapping("/controllerDeposit")
	public String deposit(HttpServletRequest req, Model m) {
		LOGGER.info("In deposit Controller");

		Integer accNum = Integer.parseInt(req.getParameter("acno"));
		Integer ammount = Integer.parseInt(req.getParameter("ammount"));
		service.deposit(accNum, ammount);
		return "index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/balance")
	public String balance() {
		return "balance";
	}

	@RequestMapping("/fundtransfer")
	public String fundtransfer() {
		return "fundtransfer";
	}

	@RequestMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}

	@RequestMapping("/deposit")
	public String deposit() {
		return "deposit";
	}

}
