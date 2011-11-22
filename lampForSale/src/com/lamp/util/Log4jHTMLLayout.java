package com.lamp.util;

import java.text.SimpleDateFormat;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.Transform;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;


public class Log4jHTMLLayout extends HTMLLayout {
	static String TRACE_PREFIX = "<br>&nbsp;&nbsp;&nbsp;&nbsp;";

	public String format(LoggingEvent event) {
		StringBuffer sbuf = new StringBuffer(super.BUF_SIZE);
		if (sbuf.capacity() > MAX_CAPACITY) {
			sbuf = new StringBuffer(BUF_SIZE);
		} else {
			sbuf.setLength(0);
		}
		sbuf.append(Layout.LINE_SEP + "<tr>" + Layout.LINE_SEP);
		sbuf.append("<td>");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		sbuf.append(format.format(event.timeStamp));
		sbuf.append("</td>" + Layout.LINE_SEP);
		String escapedThread = Transform.escapeTags(event.getThreadName());
		sbuf.append("<td title=\"" + escapedThread + " thread\">");
		sbuf.append(escapedThread);
		sbuf.append("</td>" + Layout.LINE_SEP);
		sbuf.append("<td title=\"Level\">");
		if (event.getLevel().equals(Level.DEBUG)) {
			sbuf.append("<font color=\"#339933\">");
			sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
			sbuf.append("</font>");
		} else if (event.getLevel().isGreaterOrEqual(Level.WARN)) {
			sbuf.append("<font color=\"#993300\"><strong>");
			sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
			sbuf.append("</strong></font>");
		} else {
			sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));
		}
		sbuf.append("</td>" + Layout.LINE_SEP);
		String escapedLogger = Transform.escapeTags(event.getLoggerName());
		sbuf.append("<td title=\"" + escapedLogger + " category\">");
		sbuf.append(escapedLogger);
		sbuf.append("</td>" + Layout.LINE_SEP);
		if (super.getLocationInfo()) {
			LocationInfo locInfo = event.getLocationInformation();
			sbuf.append("<td>");
			sbuf.append("类" + Transform.escapeTags(locInfo.getFileName()));
			sbuf.append(':');
			sbuf.append(locInfo.getLineNumber() + "行");
			sbuf.append("</td>" + Layout.LINE_SEP);
		}
		sbuf.append("<td title=\"Message\">");
		sbuf.append(Transform.escapeTags(event.getRenderedMessage()));
		sbuf.append("</td>" + Layout.LINE_SEP);
		sbuf.append("</tr>" + Layout.LINE_SEP);
		if (event.getNDC() != null) {
			sbuf
					.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : xx-small;\" colspan=\"6\" title=\"Nested Diagnostic Context\">");
			sbuf.append("NDC: " + Transform.escapeTags(event.getNDC()));
			sbuf.append("</td></tr>" + Layout.LINE_SEP);
		}
		String[] s = event.getThrowableStrRep();
		if (s != null) {
			sbuf
					.append("<tr><td bgcolor=\"#993300\" style=\"color:White; font-size : xx-small;\" colspan=\"6\">");
			appendThrowableAsHTML(s, sbuf);
			sbuf.append("</td></tr>" + Layout.LINE_SEP);
		}
		return sbuf.toString();
	}

	void appendThrowableAsHTML(String[] s, StringBuffer sbuf) {
		if (s != null) {
			int len = s.length;
			if (len == 0)
				return;
			sbuf.append(Transform.escapeTags(s[0]));
			sbuf.append(Layout.LINE_SEP);
			for (int i = 1; i < len; i++) {
				sbuf.append(TRACE_PREFIX);
				sbuf.append(Transform.escapeTags(s[i]));
				sbuf.append(Layout.LINE_SEP);
			}
		}
	}

	public String getHeader() {
		StringBuffer sbuf = new StringBuffer();
		sbuf
				.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"
						+ Layout.LINE_SEP);
		sbuf.append("<html>" + Layout.LINE_SEP);
		sbuf.append("<head>" + Layout.LINE_SEP);
		sbuf.append("<title>新生报到系统日志 </title>" + Layout.LINE_SEP);
		sbuf.append("<style type=\"text/css\">" + Layout.LINE_SEP);
		sbuf.append("<!--" + Layout.LINE_SEP);
		sbuf
				.append("body, table {font-family: arial,sans-serif; font-size: x-small;}"
						+ Layout.LINE_SEP);
		sbuf
				.append("th {background: #d0e3fc; color: #1d3759; text-align: left;font-size:20}"
						+ Layout.LINE_SEP);
		sbuf.append("-->" + Layout.LINE_SEP);
		sbuf.append("</style>" + Layout.LINE_SEP);
		sbuf.append("</head>" + Layout.LINE_SEP);
		sbuf
				.append("<body bgcolor=\"#FFFFFF\" topmargin=\"6\" leftmargin=\"6\">"
						+ Layout.LINE_SEP);
		// sbuf.append("<hr size=\"1\" noshade>" + Layout.LINE_SEP);
		
		// sbuf.append("此日志文件生成时间：" + FormatUtil.formatStr(new Date(),
		// "yyyy-MM-dd HH:mm") + "<br>" + Layout.LINE_SEP);
		sbuf.append("<br>" + Layout.LINE_SEP);
		sbuf
				.append("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#dddfe3\" width=\"100%\">"
						+ Layout.LINE_SEP);
		sbuf.append("<tr>" + Layout.LINE_SEP);
		sbuf.append("<th>执行时间</th>" + Layout.LINE_SEP);
		sbuf.append("<th>执行所在线程</th>" + Layout.LINE_SEP);
		sbuf.append("<th>日志级别</th>" + Layout.LINE_SEP);
		sbuf.append("<th>日志类别</th>" + Layout.LINE_SEP);
		if (super.getLocationInfo()) {
			sbuf.append("<th>Java文件:行号</th>" + Layout.LINE_SEP);
		}
		sbuf.append("<th>日志信息</th>" + Layout.LINE_SEP);
		sbuf.append("</tr>" + Layout.LINE_SEP);
		return sbuf.toString();
	}

}