package com.poo.labvisitor.task1;

import java.util.List;

import com.poo.labvisitor.task1.document.BoldTextSegment;
import com.poo.labvisitor.task1.document.ItalicTextSegment;
import com.poo.labvisitor.task1.document.PlainTextSegment;
import com.poo.labvisitor.task1.document.TextSegment;
import com.poo.labvisitor.task1.document.UrlSegment;

public class MarkdownVisitor implements DocumentVisitor {
    StringBuilder document;
    
    public MarkdownVisitor() {
        this.document = new StringBuilder();
    }
    
    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        document.append("_" + italicTextSegment.getContent() + "_");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        document.append("__" + boldTextSegment.getContent() + "__");
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        document.append("[" + urlSegment.getDescription() + "]");
        document.append("(" + urlSegment.getUrl() + ")");
    }

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        document.append(plainTextSegment.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return this.document;
    }
    
//    @Override
//    public void visit(TextSegment textSegment) {
//        if (textSegment instanceof ItalicTextSegment) {
//            document.append("_" + textSegment.getContent() + "_");
//        } else if (textSegment instanceof BoldTextSegment) {
//            document.append("__" + textSegment.getContent() + "__");
//        } else if (textSegment instanceof UrlSegment) {
//            document.append("[" + ((UrlSegment) textSegment).getDescription() + "]");
//            document.append("(" + ((UrlSegment) textSegment).getUrl() + ")");
//        } else {
//            document.append(textSegment.getContent());
//        }
//    }

}
