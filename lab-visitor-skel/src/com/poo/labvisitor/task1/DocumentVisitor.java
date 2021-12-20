package com.poo.labvisitor.task1;

import java.util.List;

import com.poo.labvisitor.task1.document.BoldTextSegment;
import com.poo.labvisitor.task1.document.ItalicTextSegment;
import com.poo.labvisitor.task1.document.PlainTextSegment;
import com.poo.labvisitor.task1.document.UrlSegment;
import com.poo.labvisitor.task1.document.TextSegment;

public interface DocumentVisitor {
    public void visit(ItalicTextSegment italicTextSegment);
    public void visit(BoldTextSegment boldTextSegment);
    public void visit(UrlSegment urlSegment);
    public void visit(PlainTextSegment plainTextSegment);
    public StringBuilder getDocument();
    
//    public void visit(TextSegment textSegment);
}