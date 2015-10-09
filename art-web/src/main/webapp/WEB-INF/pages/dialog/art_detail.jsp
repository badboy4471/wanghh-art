				<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
				<div class="block">
                            <div class="block-content collapse in">
                                <div class="span12">
						<fieldset>
							 
							<div class="control-group">
                                <label class="control-label" for="fileInput">图片*</label>
                                <div class="controls">
                                	<input class="input-file uniform_on span6 m-wrap" id="artImage" name="artImage" multiple="true" type="file">
                                	<div id="showImage"></div>
                                	<input type="hidden" name="imageUrl" id="imageUrl"/>
                            	</div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="fileInput">语音播报</label>
                                <div class="controls">
                                	<input class="input-file uniform_on" id="artAudio" name="artAudio" type="file"  multiple="true">
                                	<div id="playAudio"></div>
                                	<input type="hidden" name="audioUrl" id="audioUrl"/>
                            	</div>
                            </div>
                            
  							<div class="control-group">
  								<label class="control-label">编号<span class="required">*</span></label>
  								<div class="controls">
  									<input type="text" name="artNumber" id="artNumber" data-required="1" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">名称<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artName" type="text" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">尺寸<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artSize" type="text" class="span6 m-wrap"/> e.g: 80*60
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">材质<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artMaterial" type="text" class="span6 m-wrap"/> e.g: 瓷板.陶瓷颜料
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">作者<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artAuthor" type="text" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">证书<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artCert" type="text" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">年份</label>
  								<div class="controls">
  									<input name="artYear" type="text" class="span6 m-wrap"/> e.g: 2014年7月
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">描述</label>
  								<div class="controls">
  									<textarea rows="3" cols="120" name="artDesc"></textarea>
  								</div>
  							</div>
  							<div class="form-actions">
  								<button type="submit" class="btn btn-primary">提交</button>
  								<button type="button" class="btn">重置</button>
  							</div>
						</fieldset>
					</form>
					<!-- END FORM-->
				</div>
			    </div>
			</div>