package com.thymeproj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thymeproj.model.Bank;




@Controller
public class ExampleController 
{
	@GetMapping("/hello")
	public String display(Model model)
	{
		model.addAttribute("name", "Mr. Kapil Pise");
		return "Welcome";
	}
	
	
	@GetMapping("/allbanksdata")
	public String info(Model model)
	{
		Bank b1 = new Bank(101,"HSBC","Bund Garden","HSBC2642");
		Bank b2 = new Bank(202,"SBI","FC Road","SBI000242");
		Bank b3 = new Bank(303,"SBS","Gangtok","SBS2342");
		
		List<Bank> banks = new ArrayList<Bank>();
		banks.add(b1);
		banks.add(b2);
		banks.add(b3);
		
		model.addAttribute("allbanks", banks);
		
		return "Bankdata"; //This is the HTML File name.
		
	}

}

