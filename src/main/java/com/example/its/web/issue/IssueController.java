package com.example.its.web.issue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form) {
        return "issues/creationForm";
    }

    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }

    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";
    }

    @GetMapping("/editForm/{issueId}")
    public String showEditForm(@PathVariable("issueId") long issueId, @ModelAttribute IssueForm form) {
        IssueEntity issueEntity = issueService.findById(issueId);
        form.setId(issueId);
        form.setSummary(issueEntity.getSummary());
        form.setDescription(issueEntity.getDescription());
        return "issues/editForm";
    }

    @PostMapping("/update/{issueId}")
    public String update(@PathVariable("issueId") long issueId, @Validated IssueForm form, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "issues/editForm";
        }
        issueService.update(form.getSummary(), form.getDescription(), issueId);
        return "redirect:/issues";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long issueId) {
        issueService.deleteById(issueId);
        return "redirect:/issues";
    }
}
