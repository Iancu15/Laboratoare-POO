package com.poo.labvisitor.task1;

import java.util.List;

import com.poo.labvisitor.task1.document.BoldTextSegment;
import com.poo.labvisitor.task1.document.ItalicTextSegment;
import com.poo.labvisitor.task1.document.PlainTextSegment;
import com.poo.labvisitor.task1.document.TextSegment;
import com.poo.labvisitor.task1.document.UrlSegment;

public class DokuWikiVisitor implements DocumentVisitor {
    StringBuilder document;
    
    public DokuWikiVisitor() {
        this.document = new StringBuilder();
    }
    
    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        document.append("//" + italicTextSegment.getContent() + "//");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        document.append("**" + boldTextSegment.getContent() + "**");
     }

    @Override
    public void visit(UrlSegment urlSegment) {
        document.append("[[" + urlSegment.getUrl() + "|");
        document.append(urlSegment.getDescription() + "]]");
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
//            document.append("//" + textSegment.getContent() + "//");
//        } else if (textSegment instanceof BoldTextSegment) {
//            document.append("**" + textSegment.getContent() + "**");
//        } else if (textSegment instanceof UrlSegment) {
//            document.append("[[" + ((UrlSegment) textSegment).getUrl() + "|");
//            document.append(((UrlSegment) textSegment).getDescription() + "]]");
//        } else {
//            document.append(textSegment.getContent());
//        }
//    }

}
