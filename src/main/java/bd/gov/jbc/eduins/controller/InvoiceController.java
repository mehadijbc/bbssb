package bd.gov.jbc.eduins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bd.gov.jbc.eduins.entity.Invoice;
import bd.gov.jbc.eduins.repository.InvoiceRepository;
import bd.gov.jbc.eduins.service.IExcelDataService;
import bd.gov.jbc.eduins.service.IFileUploaderService;

@Controller
public class InvoiceController {

	@Autowired
	IFileUploaderService fileService;

	@Autowired
	IExcelDataService excelservice;

	@Autowired
	InvoiceRepository repo;

	@GetMapping("/")
	public String index() {
		return "uploadPage";
	}

	@PostMapping("/")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		fileService.uploadFile(file);

		redirectAttributes.addFlashAttribute("message",
				"You have successfully uploaded '" + file.getOriginalFilename() + "' !");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping("/saveData")
	public String saveExcelData(Model model) {

		List<Invoice> excelDataAsList = excelservice.getExcelDataAsList();
		int noOfRecords = excelservice.saveExcelData(excelDataAsList);
		model.addAttribute("noOfRecords", noOfRecords);
		return "success";
	}
}