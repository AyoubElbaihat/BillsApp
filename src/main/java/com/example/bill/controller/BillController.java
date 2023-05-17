package com.example.bill.controller;

import com.example.bill.entity.Bill;
import com.example.bill.entity.Customer;
import com.example.bill.entity.Product;
import com.example.bill.service.BillService;
import com.example.bill.service.CustomerService;
import com.example.bill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @GetMapping("/bills")
    public String showBills(Model model) {
        List<Bill> bills = billService.getAllBills();
        model.addAttribute("bills", bills);
        return "bills";
    }

    @GetMapping("/bills/new")
    public String showCreateBillForm(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        List<Product> products = productService.getAllProducts();
        model.addAttribute("bill", new Bill());
        model.addAttribute("customers", customers);
        model.addAttribute("products", products);
        return "create-bill";
    }

    @PostMapping("/bills")
    public String createBill(@ModelAttribute("bill") Bill bill, @RequestParam("products") List<Long> productIds) {
        LocalDate invoiceDate = bill.getInvoiceDate();
        bill.setDueDate(invoiceDate.plusMonths(1));
        List<Product> selectedProducts = productService.getProductsByIds(productIds);
        bill.setProducts(selectedProducts);
        billService.saveBill(bill);
        return "redirect:/bills";
    }

}

